package com.inetbanking.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;




public class LOG4j2demo {

	private static Logger Logger = LogManager.getLogger(LOG4j2demo.class);
	
	@Test
	
	public void test() {
		
		Logger.debug("This is debug mesasage domlogger");
		Logger.debug("This is Info mesasage domlogger");
		Logger.debug("This is warn mesasage domlogger");
		Logger.debug("This is error mesasage domlogger");
		Logger.debug("This is fatal mesasage domlogger");
	}
	
}
