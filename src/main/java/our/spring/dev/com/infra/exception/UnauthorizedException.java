package our.spring.dev.com.infra.exception;

import our.spring.dev.com.infra.exception.base.AppException;

public class UnauthorizedException extends AppException {
    private static final String UNAUTHORIZED = "unauthorized";

    public UnauthorizedException() {
        super(UNAUTHORIZED);
    }
}