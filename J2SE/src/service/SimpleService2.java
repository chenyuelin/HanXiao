package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleService2 {
	private static final Log LOG = LogFactory.getLog(SimpleService2.class);

	public int addFour(int num) {
		LOG.debug("Call addFour start.");
		int result = num + 4;
		LOG.debug("Call addFour end.");
		return result;
	}
}
