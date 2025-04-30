package com.asheef.user_service.utils;

import com.asheef.common_utils.response.ErrorStructure;
import com.asheef.user_service.constants.Constant;
import com.asheef.user_service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorStructure> userNotFoundHandler(UserNotFoundException e) {
        return new ResponseEntity<>(new ErrorStructure(HttpStatus.NOT_FOUND.value(), e.getMessage(), Constant.USER_FOUND), HttpStatus.NOT_FOUND);
    }
}
