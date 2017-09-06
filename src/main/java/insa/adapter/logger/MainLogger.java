package insa.adapter.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.JDK14LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;

public class MainLogger {
	// In various cases we will face such a logger defined as a constant and static class attribute.
	private static final Logger LOGGER = Logger.getLogger(MainLogger.class.getName());

	static {
		// An important feature of loggers is the level of importance you set during the development and while doing a release
		LOGGER.setLevel(Level.ALL);
	}


	public static void main(final String[] args) {
		final Logger jdkLogger = Logger.getLogger("Main");
		final Logger jdkLogger2 = Logger.getLogger("Main");

		// These two loggers are in fact the same logger called Main.
		System.out.printf("%s %s %n", jdkLogger, jdkLogger2);

		// Adding a listener to the JDK logger.
		jdkLogger2.addHandler(new Handler() {
			@Override
			public void publish(final LogRecord record) {
				System.out.printf(">>>> %s", record.getMessage());
			}
			@Override
			public void flush() {}
			@Override
			public void close() throws SecurityException {}
		});

		// Some log messages
		jdkLogger.log(Level.SEVERE, "crash");
		jdkLogger.log(Level.FINE, "coucou");
		jdkLogger.log(Level.SEVERE, "crash", new NullPointerException());
		jdkLogger.severe("encore crash");

		// Creating a Log4J logger.
		final org.apache.log4j.Logger log4jLogger = org.apache.log4j.Logger.getLogger("log4jLogger");

		// Creating a slf4f logger.
		final org.slf4j.Logger slf4j = LoggerFactory.getLogger("mySlf4j");

		// Creating a slf4j adapter to use the JDK logger as a slf4j logger.
		final org.slf4j.Logger jdkAdapter = new JDK14LoggerFactory().getLogger("Main");
		// The slf4j logger will send log messages to the JDK logger called 'Main'
		jdkAdapter.error("an error message from slf4J to a JDK logger");


		// Creating a Log4J adapter to use the Log4j logger as a slf4j logger.
		final org.slf4j.Logger log4jadapter = new Log4jLoggerFactory().getLogger("log4jLogger");

		// The slf4j logger will send log messages to the slf4J logger called 'mySlf4j'
		log4jadapter.error("an error message from slf4J to a Log4j logger");
	}
}
