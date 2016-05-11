package com.git.log.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将log4j日志文件输入到控制台
 * @author songqinghu
 *
 */
public class Log4jConsoleDemo {

    private  static Logger logger = LoggerFactory.getLogger(Log4jConsoleDemo.class);
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            logger.error("this is for time {} with error",i);
        }
        for (int i = 0; i < 10; i++) {
            logger.debug("this is for time {} with error",i);
        }
    }
    
}
