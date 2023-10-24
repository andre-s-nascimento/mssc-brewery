package guru.springframework.msscbrewery.web.controller;

import jakarta.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MVCExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<String>> validationErrorHandler(MethodArgumentNotValidException e) {
    List<String> errors = new ArrayList<>(e.getErrorCount());

    e.getFieldErrors().forEach(
        fieldError -> errors.add(
            fieldError.getObjectName() + "." + fieldError.getField() + " : "
                + fieldError.getDefaultMessage())
    );

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
    List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
    e.getConstraintViolations().forEach(
        constraintViolation -> errors.add(
            constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage())
    );

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<List<ObjectError>> handleBindException(BindException ex) {
    return new ResponseEntity<>(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
  }

}
