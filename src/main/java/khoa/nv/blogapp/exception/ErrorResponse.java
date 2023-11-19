package khoa.nv.blogapp.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private final String timestamp;
    private final String message;
    private Object errors;

    public ErrorResponse(String message) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
    }

    public ErrorResponse(String message, Object errors) {
        this(message);
        this.errors = errors;
    }
}
