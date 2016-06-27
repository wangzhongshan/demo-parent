package pers.wzsframework.demo.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class slf4jLog4jTest {
	
	
	public static void main(String[] args) {
		/**
		 * 不用采用static成员变量来定义logger，slf4j本来就是单例模式
		 */
		Logger logger = LoggerFactory.getLogger(slf4jLog4jTest.class);
		// 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message."); 
	}

}
