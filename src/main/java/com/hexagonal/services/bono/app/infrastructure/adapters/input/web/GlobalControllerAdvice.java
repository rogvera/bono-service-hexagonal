package com.hexagonal.services.bono.app.infrastructure.adapters.input.web;

import com.hexagonal.services.bono.app.domain.exception.BonoNotFoundException;
import com.hexagonal.services.bono.app.domain.exception.DuplicateBonoException;
import com.hexagonal.services.bono.app.domain.model.ErrorMessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Collectors;

import static com.hexagonal.services.bono.app.utils.ErrorMessages.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(BonoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
    public ErrorMessageResponse handleBonoNotFoundException(HttpServletRequest req, Exception e) {
        return ErrorMessageResponse.builder()
                .exception(e.getClass().getSimpleName())
                .code(BONO_NOT_FOUND.getCode())
                .message(BONO_NOT_FOUND.getMessage())
                .path(req.getRequestURI())
                .build();
    }

    @ExceptionHandler(DuplicateBonoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
//    @ResponseBody
    public ErrorMessageResponse handleDuplicateBonoException(HttpServletRequest req, Exception e) {
        return ErrorMessageResponse.builder()
                .exception(e.getClass().getSimpleName())
                .code(DUPLICATE_BONO.getCode())
                .message(DUPLICATE_BONO.getMessage())
                .path(req.getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
    public ErrorMessageResponse handleMethodArgumentNotValidException(HttpServletRequest req,
            MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        return ErrorMessageResponse.builder()
                .exception(e.getClass().getSimpleName())
                .code(INVALID_BONO.getCode())
                .message(INVALID_BONO.getMessage())
                .path(req.getRequestURI())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
//    @ResponseBody
    public ErrorMessageResponse handleGenericError(HttpServletRequest req, Exception e) {
        return ErrorMessageResponse.builder()
                .exception(e.getClass().getSimpleName())
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .path(req.getRequestURI())
                .build();
    }
}
