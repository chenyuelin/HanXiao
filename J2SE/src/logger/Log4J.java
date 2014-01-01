package logger;

import org.apache.log4j.Logger;

public class Log4J {
	private static final Logger LOGGER=Logger.getLogger(Log4J.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.error("I'm error message.");
		LOGGER.warn("I'm warn message.");
		LOGGER.info("I'm info message.");
		LOGGER.debug("I'm debug message.");
		LOGGER.trace("I'm trace message.");
	}

}
