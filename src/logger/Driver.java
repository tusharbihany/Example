package logger;

import logger.forwarder.LoggerRegistry;
import logger.impl.LoggerImpl;
import logger.models.LogContext;
import logger.models.LogLevel;
import logger.sink.ConsoleLogSink;
import logger.sink.LogSink;

public class Driver {

    public static void main(String[] args) {
        LogSink console = new ConsoleLogSink();
        LoggerRegistry.getInstance().subscribe(console, LogLevel.INFO);
        LoggerImpl logger = new LoggerImpl();
        logger.info("Hello", LogContext.builder().application("test").timestamp(System.currentTimeMillis()).build());
        logger.debug("Hi", LogContext.builder().application("test").timestamp(System.currentTimeMillis()).build());
        LoggerRegistry.getInstance().unsubscribe(console, LogLevel.INFO);
        logger.info("Hello", LogContext.builder().application("test").timestamp(System.currentTimeMillis()).build());
    }
}
