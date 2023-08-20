package com.rcp.gitrepo.web.controller;


import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.rcp.gitrepo.exception.CommunicationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, CommunicationException.class})
    protected ProblemDetail handleInternalServerError(Exception exception) {
        return ProblemDetail.forStatusAndDetail(INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    protected ProblemDetail handleValidationError(Exception exception) {
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, exception.getMessage());
    }

}
