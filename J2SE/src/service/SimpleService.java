package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleService {
	private static final Log LOG = LogFactory.getLog(SimpleService.class);

	private SimpleService2 simpleService2;
	
	public String generatePrefix(String prefix, String content) {
		LOG.debug("Call generatePrefix start.");
		if (prefix == null || content == null) {
			throw new NullPointerException();
		}
		String result = prefix + "*" + content;
		LOG.debug("Call generatePrefix end.");
		return result;
	}

	public int addTen(int num) {
		LOG.debug("Call addTen start.");
		int result = simpleService2.addFour(num) + 6;
		LOG.debug("Call addTen end.");
		return result;
	}

//	public int addFour(int num) {
//		LOG.debug("Call addFour start.");
//		int result = num + 4;
//		LOG.debug("Call addFour end.");
//		return result;
//	}

	public SimpleService2 getSimpleService2() {
		return simpleService2;
	}

	public void setSimpleService2(SimpleService2 simpleService2) {
		this.simpleService2 = simpleService2;
	}
}
