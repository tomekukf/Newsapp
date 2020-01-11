package com.tomek.domanski.exceptions.handlers;

import com.tomek.domanski.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataParsingException(DataNotFoundException exception) {
        return new ResponseEntity<>(exception.getClass().getSimpleName(), HttpStatus.NOT_FOUND);
    }

}
