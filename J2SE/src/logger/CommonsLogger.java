package logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLogger {
	//logger.CommonsLogger
	private static final Log LOG = LogFactory.getLog(CommonsLogger.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.error("I'm error message.");
		LOG.warn("I'm warn message.");
		LOG.info("I'm info message.");
		LOG.debug("I'm debug message.");
		LOG.trace("I'm trace message.");
	}

}
