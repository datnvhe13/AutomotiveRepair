package com.vti.config.exception;//package com.vti.config.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.validation.ConstraintViolationException;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach(objecError -> {
//            String field = ((FieldError) objecError).getField();
//            String message = objecError.getDefaultMessage();
//            errors.put(field, message);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception){
//        Map<String, String> errors = new HashMap<>();
//        exception.getConstraintViolations().forEach(constraintViolation -> {
//            String path = constraintViolation.getPropertyPath().toString();
//            String message = constraintViolation.getMessage();
//            errors.put(path, message);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//
//}
