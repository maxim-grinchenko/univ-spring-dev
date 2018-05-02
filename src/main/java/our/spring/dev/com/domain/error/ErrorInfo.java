package our.spring.dev.com.domain.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ErrorInfo {
    private int status;
    private String path;
    private String exception;
    private String message;
    private long time;
}