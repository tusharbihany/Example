package logger.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class LogContext {
    @NonNull
    private long timestamp;
    @NonNull
    private String application;
}
