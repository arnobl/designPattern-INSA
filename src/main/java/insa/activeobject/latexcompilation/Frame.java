package insa.activeobject.latexcompilation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Frame extends JFrame {
	final JTextField textField;
	final DrawingArea drawingArea;
	final ExecutorService service;

	public Frame() {
		super("Test active Object");
		textField = new JTextField();
		textField.setColumns(50);
		service = Executors.newFixedThreadPool(3);
		drawingArea = new DrawingArea();

		// Creation of a future task when enter new LaTeX text in the text field.
		textField.addActionListener(e -> {
			MyFutureTask task = new MyFutureTask(textField, drawingArea);
			drawingArea.futureImage = task;
			// The task is submitted to the task executor.
			service.submit(task);
			drawingArea.repaint();
		});

		final JPanel textFieldPanel = new JPanel();
		setLayout(new BorderLayout());
		textFieldPanel.add(textField);
		getContentPane().add(textFieldPanel, BorderLayout.NORTH);
		getContentPane().add(drawingArea, BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setLocation(400, 300);
	}


	class DrawingArea extends JPanel {
		Image image;
		Future<Image> futureImage;

		public DrawingArea() {
			super();
			setPreferredSize(new Dimension(600, 400));
		}

		@Override
		public void paint(final Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLACK);
			// On repaint the future object is tested to check whether the task is over.
			try {
				if(futureImage != null && futureImage.isDone() && futureImage.get() != null) {
					// If the task is over, getting the picture to be painted.
					if(image != null) image.flush();
					image = futureImage.get();
					futureImage = null;
				}
			}catch(final InterruptedException | ExecutionException ex) {
				ex.printStackTrace();
			}

			// If the task is not over or if its execution did not produce a picture, a text is painted
			if(image == null) {
				g.drawString(Frame.this.textField.getText(), 100, 100);
			}else {
				// Otherwise the created image is painted.
				g.drawImage(image, 100, 100, null);
			}
		}
	}
}
