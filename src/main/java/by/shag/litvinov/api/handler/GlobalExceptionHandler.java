package by.shag.litvinov.api.handler;

import by.shag.litvinov.exception.EntityDuplicationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBody> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = composeValidationErrors(e.getBindingResult().getAllErrors());
        ResponseBody exceptionResponse = new ResponseBody(
                errors, HttpStatus.BAD_REQUEST, Instant.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseBody> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ResponseBody exceptionResponse = new ResponseBody(
                Collections.singletonList(e.getCause().getMessage()), HttpStatus.BAD_REQUEST, Instant.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityDuplicationException.class)
    public ResponseEntity<ResponseBody> handlerMethodArgumentNotValidException(EntityDuplicationException e) {
        ResponseBody exceptionResponse = new ResponseBody(
                Collections.singletonList(e.getMessage()), HttpStatus.BAD_REQUEST, Instant.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseBody> handlerMethodArgumentNotValidException(EntityNotFoundException e) {
        ResponseBody exceptionResponse = new ResponseBody(
                Collections.singletonList(e.getMessage()), HttpStatus.NOT_FOUND, Instant.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("unchecked")
    private List<String> composeValidationErrors(List<ObjectError> objectErrors) {
        return objectErrors != null && !objectErrors.isEmpty() ? (List) objectErrors.stream().map((objectError) -> {
            return objectErrors instanceof FieldError ? ((FieldError) objectError).getField() + " " + ((FieldError) objectErrors).getDefaultMessage() : objectError.getDefaultMessage();
        }).collect(Collectors.toList()) : Collections.emptyList();
    }

    @Data
    @AllArgsConstructor
    private class ResponseBody {
        private List<String> message;
        private HttpStatus status;
        private Instant time;
    }
}
