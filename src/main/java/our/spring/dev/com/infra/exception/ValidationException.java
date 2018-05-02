package our.spring.dev.com.infra.exception;

import net.sf.oval.ConstraintViolation;
import our.spring.dev.com.infra.exception.base.AppException;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationException extends AppException {
    public ValidationException(String message, List<ConstraintViolation> violations) {
        super(message + ":" + violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
    }

    public ValidationException(String message) {
        super(message);
    }
}