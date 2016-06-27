package pers.wzsframework.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {

	public static void main(String[] args) {
		/**
		 * 不需要定义成为static成员变量，LoggerFactory本来就是单例模式，直接在代码中调用即可.
		 * logback只支持xml格式的配置
		 */
		Logger logger=LoggerFactory.getLogger(LogBackTest.class);
		
		logger.debug("this debug {}.","logback");
		logger.info("this info {}.","logback");
		logger.error("this error {}.","logback");
		
	}
}
