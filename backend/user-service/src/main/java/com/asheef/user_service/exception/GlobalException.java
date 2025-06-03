package com.asheef.user_service.exception;

import com.asheef.common_utils.response.ErrorStructure;
import com.asheef.common_utils.response.ResponseDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class GlobalException {


    /**
     * Global Exception for RequestBody Dto Validation
     *
     * @param exception
     * @return errors Structure
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> buildMethodInValidException(MethodArgumentNotValidException exception) {
        var errors = new ArrayList<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ErrorStructure errorStructure = new ErrorStructure(
                    String.valueOf(error.getRejectedValue()),
                    error.getDefaultMessage(), error.getField()
            );
            errors.add(errorStructure);
        }
        ResponseDto response = new ResponseDto(Boolean.FALSE, HttpStatus.BAD_REQUEST.value(), errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * This is for handle Exception the dto Validation if the method accepting @ModelAttribute
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> buildBindException(BindException exception) {

        var errors = new ArrayList<>();

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ErrorStructure errorStructure = new ErrorStructure(String.valueOf(error.getRejectedValue()),
                    error.getDefaultMessage(), error.getField());
            errors.add(errorStructure);
        }

        ResponseDto response = new ResponseDto(Boolean.FALSE, HttpStatus.BAD_REQUEST.value(), errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        var errors = new ArrayList<ErrorStructure>();
        ex.getConstraintViolations().forEach(violation -> {
            ErrorStructure errorStructure = new ErrorStructure(
                    String.valueOf(violation.getInvalidValue()),
                    violation.getMessage(),
                    violation.getPropertyPath().toString()
            );
            errors.add(errorStructure);
        });

        ResponseDto response = new ResponseDto(Boolean.FALSE, HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
