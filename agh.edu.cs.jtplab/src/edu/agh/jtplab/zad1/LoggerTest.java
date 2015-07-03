package edu.agh.jtplab.zad1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggerTest {
	private static final Logger logger = (Logger) LogManager
			.getLogger(LoggerTest.class.getName());

	public void doIt() {
		logger.debug("THis is logger info ");
	}
}