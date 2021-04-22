package logger.forwarder;

import logger.models.LogLevel;
import logger.sink.LogSink;

import java.util.*;

public class LoggerRegistry {

    private final Map<LogLevel, Set<LogSink>> registry;
    private LoggerRegistry() {
        registry = new EnumMap<LogLevel, Set<LogSink>>(LogLevel.class);
    }

    private static LoggerRegistry INSTANCE;

    public static LoggerRegistry getInstance() {
        if(INSTANCE == null) {
            synchronized (LoggerRegistry.class) {
                if(INSTANCE == null)
                    INSTANCE = new LoggerRegistry();
            }
        }
        return INSTANCE;
    }

    public void subscribe(LogSink logSink, LogLevel logLevel) {
        if(!registry.containsKey(logLevel))
            registry.put(logLevel, new HashSet<>());
        registry.get(logLevel).add(logSink);
    }

    public void unsubscribe(LogSink logSink, LogLevel logLevel) {
        if(!registry.containsKey(logLevel))
            return;
        registry.get(logLevel).remove(logSink);
    }

    Set<LogSink> getSinksForLogLevel(LogLevel logLevel) {
        if(!registry.containsKey(logLevel))
            return Collections.emptySet();
        return registry.get(logLevel);
    }
}
