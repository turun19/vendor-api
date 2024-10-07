package com.example.technicaltestptsisi.exception;

import com.example.technicaltestptsisi.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandlers {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });

        if (!errors.isEmpty()) {
            String errorMessage = String.join(", ", errors);
            BaseResponse<String> errorResponse = BaseResponse.failure(
                    HttpStatus.BAD_REQUEST.value(),
                    errorMessage
            );
            return ResponseEntity.badRequest().body(errorResponse);
        }

        return ResponseEntity.badRequest().body(null);
    }
}
