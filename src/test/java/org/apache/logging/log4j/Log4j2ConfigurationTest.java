package org.apache.logging.log4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Run this app to log a few messages and check the output.
 * <p>
 * TODO - Automate the validation.
 */
public class Log4j2ConfigurationTest {
    static final Logger logger = LoggerFactory.getLogger(Log4j2ConfigurationTest.class);
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testInfoMessage() {
        logger.info("This is an INFO log message");
    }

    @Test
    public void testWarnMessage() {
        logger.warn("This is an WARN log message");
    }

    @Test
    public void testErrorMessage() {
        logger.error("This is an INFO log message");
    }

    @Test
    public void testDebugMessage() {
        logger.debug("This is an INFO log message");
    }

    @Test
    public void testTraceMessage() {
        logger.trace("This is an INFO log message");
    }

}
