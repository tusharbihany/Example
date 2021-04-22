package logger.sink;

import logger.models.LogMessage;

public interface LogSink {
    void dumpLog(LogMessage logMessage);
}
