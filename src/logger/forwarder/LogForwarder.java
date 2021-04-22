package logger.forwarder;

import logger.models.LogMessage;

public class LogForwarder {

    public void forwardLog(LogMessage logMessage) {
        LoggerRegistry.getInstance().getSinksForLogLevel(logMessage.getLogLevel()).forEach(logSink -> {
            logSink.dumpLog(logMessage);
        });
    }
}
