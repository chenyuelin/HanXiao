package logger;

import java.util.logging.Logger;

public class JdkLogger {
    private static final Logger LOGGER=Logger.getLogger(JdkLogger.class.getName());
	
	public static void main(String[] args) {
		LOGGER.severe("123");
		

	}

}
