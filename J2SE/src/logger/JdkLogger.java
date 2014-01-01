package logger;

import java.util.logging.Logger;

public class JdkLogger {
	private static final Logger LOGGER = Logger.getLogger(JdkLogger.class.getName());

	public static void main(String[] args) {
		LOGGER.warning("I'm warning severe.");
		//Doing something.
		LOGGER.severe("I'm severe severe.");
		LOGGER.info("I'm info logger.");
		//Doing something.
		LOGGER.config("I'm config logger.");
		LOGGER.finest("I'm finest logger.");
		//Doing something.
		
		try{
			//TODO
			throw new RuntimeException();
		}catch(Exception e){
			LOGGER.warning(e.getMessage());
			LOGGER.severe(e.getMessage());
		}
	}
	
	public void atcion(){
		LOGGER.config("Do atcion start.");
		//TODO
		LOGGER.config("Do atcion end.");
	}

}
