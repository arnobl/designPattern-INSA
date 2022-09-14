package future.latexcompilation;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import future.latexcompilation.helpers.ImageCropper;
import future.latexcompilation.helpers.StreamExecReader;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Callable;


public class LatexBuilder implements Callable<Image> {
	String text;

	public LatexBuilder(final String txt) {
		super();
		text = txt;
	}

	private String getLaTeXDocument() {
		return "\\documentclass[10pt]{article}\n\\usepackage[usenames,dvipsnames]{pstricks}\n\\usepackage{mathtools}\\usepackage[left=0cm,top=0cm," +
			"right=0cm,nohead,nofoot,paperwidth=50cm,paperheight=8cm]{geometry}\n\\pagestyle{empty}\n\\begin{document}\n" + text + "\n\\end{document}";
	}


	private String execute(final String[] cmd) {
		String log;
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			StreamExecReader errReader = new StreamExecReader(process.getErrorStream());
			StreamExecReader outReader = new StreamExecReader(process.getInputStream());

			errReader.start();
			outReader.start();

			if(process.waitFor() == 0) return "";

			log = outReader.getLog() + "\n" + errReader.getLog();
		}catch(Exception ex) { log = ex.getMessage(); }
		return log;
	}


	@Override
	public Image call() {
		return createImage();
	}


	/**
	 * @return The LaTeX compiled picture of the text with its file path and its log, or None.
	 * @since 3.0
	 */
	public Image createImage() {
		File tmpDir = createTempDir();
		String doc = getLaTeXDocument();
		String pathPic = tmpDir.getAbsolutePath() + System.getProperty("file.separator") + "latexdrawTmpPic" + System.currentTimeMillis();
		String pathTex = pathPic + ".tex";
		Image bi = null;

		try(FileOutputStream fos = new FileOutputStream(pathTex); OutputStreamWriter osw = new OutputStreamWriter(fos)) {
			osw.append(doc);
			osw.flush();
			fos.flush();

			execute(new String[]{"latex", "--halt-on-error", "--interaction=nonstopmode", "--output-directory=" + tmpDir.getAbsolutePath(), pathTex});

			new File(pathTex).delete();
			new File(pathPic + ".aux").delete();
			new File(pathPic + ".log").delete();

			execute(new String[]{"dvips", pathPic + ".dvi", "-o", pathPic + ".ps"});
			new File(pathPic + ".dvi").delete();
			execute(new String[]{"ps2pdf", pathPic + ".ps", pathPic + ".pdf"});
			new File(pathPic + ".ps").delete();
			File file = new File(pathPic + ".pdf");
			try(RandomAccessFile raf = new RandomAccessFile(file, "r"); FileChannel fc = raf.getChannel()) {
				MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
				PDFFile pdfFile = new PDFFile(mbb);
				mbb.clear();

				if(pdfFile.getNumPages() == 1) {
					PDFPage page = pdfFile.getPage(0);
					Rectangle2D bound = page.getBBox();
					Image img = page.getImage((int) bound.getWidth(), (int) bound.getHeight(), bound, null, false, true);

					if(img instanceof BufferedImage) {
						bi = ImageCropper.INSTANCE.cropImage((BufferedImage) img);
					}

					if(img != null) {
						img.flush();
					}
				}
				file.delete();
			}catch(Exception ex) { ex.printStackTrace(); }
		}catch(Exception ex) { ex.printStackTrace(); }
		return bi;
	}


	public File createTempDir() {
		final String pathTmp = System.getProperty("java.io.tmpdir");
		final String path = pathTmp + System.getProperty("file.separator") + "fooofooofooTmp" + System.currentTimeMillis() + (int) (Math.random() * 100000);
		final File tmpDir = new File(path);
		final boolean ok = tmpDir.mkdirs();

		if(ok) {
			tmpDir.setReadable(false, false);
			tmpDir.setReadable(true, true);
			tmpDir.setWritable(false, false);
			tmpDir.setWritable(true, true);
			tmpDir.deleteOnExit();
		}

		return ok ? tmpDir : null;
	}
}
