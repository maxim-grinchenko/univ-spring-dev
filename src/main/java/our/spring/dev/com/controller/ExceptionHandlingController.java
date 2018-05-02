package our.spring.dev.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import our.spring.dev.com.domain.error.ErrorInfo;
import our.spring.dev.com.infra.exception.ValidationException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(DataIntegrityViolationException ex) {
        // Nothing to do
        LOGGER.error(ex.getMessage(), ex);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ErrorInfo validationError(ValidationException ex, HttpServletRequest req) {
        LOGGER.error(ex.getMessage(), ex);
        return ErrorInfo.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .path(req.getServletPath())
                .time(new Date().getTime())
                .exception(ex.getClass().getName())
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo exceptionError(Exception ex, HttpServletRequest req) {
        LOGGER.error(ex.getMessage(), ex);
        return ErrorInfo.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .path(req.getServletPath())
                .time(new Date().getTime())
                .exception(ex.getClass().getName())
                .message(ex.getMessage())
                .build();
    }
}