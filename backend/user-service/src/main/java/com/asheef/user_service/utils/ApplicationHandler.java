package com.asheef.user_service.utils;

import com.asheef.common_utils.response.ErrorStructure;
import com.asheef.user_service.constants.Constant;
import com.asheef.user_service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorStructure> userNotFoundHandler(UserNotFoundException e) {
        return new ResponseEntity<>(new ErrorStructure(HttpStatus.NOT_FOUND.value(), e.getMessage(), Constant.USER_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorStructure> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<ErrorStructure> errorList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorStructure(
                        400,
                        fieldError.getDefaultMessage(),
                        fieldError.getField()
                ))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorStructure(HttpStatus.BAD_REQUEST.value(),errorList,Constant.FAILED),
                HttpStatus.BAD_REQUEST);
    }
}
