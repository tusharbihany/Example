package logger.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class LogMessage {
    @NonNull
    private LogLevel logLevel;
    private String message;
    @NonNull
    private long timeStamp;
}
