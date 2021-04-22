package logger.sink;

import logger.models.LogMessage;

public class ConsoleLogSink implements LogSink{
    @Override
    public void dumpLog(LogMessage logMessage) {
        System.out.println(logMessage);
    }
}
