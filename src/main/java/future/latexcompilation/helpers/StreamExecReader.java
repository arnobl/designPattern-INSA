package future.latexcompilation.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class StreamExecReader extends Thread {
	/** The stream to listen. */
	private final InputStream stream;

	/** The read log. */
	private StringBuilder log;


	/**
	 * Default constructor.
	 * @param is The stream to listen.
	 */
	public StreamExecReader(final InputStream is) {
		super();
		stream = Objects.requireNonNull(is);
	}


	@Override
	public void run() {
		try {
			try(final InputStreamReader isr = new InputStreamReader(stream);
				final BufferedReader br = new BufferedReader(isr)) {
				log = new StringBuilder();
				String line = br.readLine();

				while(line != null) {
					log.append(line).append("\n");
					line = br.readLine();
				}
			}
		}catch(IOException ex) { ex.printStackTrace(); }
	}


	/**
	 * @return The read log.
	 */
	public String getLog() {
		return log == null ? "" : log.toString();
	}
}
