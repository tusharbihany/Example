package logger.impl;

import logger.forwarder.LogForwarder;
import logger.models.LogContext;
import logger.models.LogLevel;
import logger.models.LogMessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoggerImpl {

    private final LogFormatter logFormatter;
    private final LogForwarder logForwarder;
    private final ExecutorService executorService;
    public LoggerImpl() {
        this.logFormatter = new LogFormatter();
        this.logForwarder = new LogForwarder();
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void info(String message, LogContext logContext) {
        submitAsync(logFormatter.formatLog(message, LogLevel.INFO, logContext));
    }

    public void debug(String message, LogContext logContext) {
        submitAsync(logFormatter.formatLog(message, LogLevel.DEBUG, logContext));
    }

    public void error(String message, LogContext logContext) {
        submitAsync(logFormatter.formatLog(message, LogLevel.ERROR, logContext));
    }

    private void submitAsync(LogMessage logMessage) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                logForwarder.forwardLog(logMessage);
            }
        });
    }
}
