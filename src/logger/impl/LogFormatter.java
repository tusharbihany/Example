package logger.impl;

import logger.models.LogContext;
import logger.models.LogLevel;
import logger.models.LogMessage;

public class LogFormatter {

    public LogMessage formatLog(String message, LogLevel logLevel, LogContext logContext) {
        return new LogMessage(logLevel, message, logContext.getTimestamp());
    }
}
