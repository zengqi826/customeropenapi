/**
 * 
 */
package com.example.openapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.openapi.model.exception.ErrorResponse;
import com.example.openapi.model.exception.TypeEnum;

/**
 * @author 86211
 *
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse constraintViolationException(ConstraintViolationException ex, HttpServletRequest req) {
        return new ErrorResponse("invalidRequest", "Missing or invalid parameters", req.getRequestURI(),
                TypeEnum.INVALID, ex.getMessage());
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse illegalArgumentException(IllegalArgumentException ex, HttpServletRequest req) {
        return new ErrorResponse("invalidRequest", "Missing or invalid parameters", "", TypeEnum.INVALID,
                ex.getMessage());
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noHandlerFoundException(NoHandlerFoundException ex) {
        return new ErrorResponse("resourceNotFound", "Empty resource/resource not found", ex.getRequestURL(),
                TypeEnum.ERROR, ex.getMessage());
    }

    @ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
            HttpServletRequest req) {
        return new ErrorResponse("resourceNotFound", "Missing or invalid parameters", req.getRequestURI(),
                TypeEnum.INVALID, ex.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse unknownException(Exception ex, HttpServletRequest req) {
        return new ErrorResponse("serverUnavailable", "The request failed due to an internal error",
                req.getRequestURI(), TypeEnum.FATAL, ex.getMessage());
    }
}
