package com.silvabrendon.dslist.controllers;

import com.silvabrendon.dslist.exceptions.ResourceException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(ResourceException.class)
    public ProblemDetail handleResourceException(ResourceException e) {
        return e.toProblemDetail();
    }

}
