package com.umcs.barbershop.infrastructure.exception;


import com.umcs.barbershop.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(HaircutNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleHaircutNotFoundException(HaircutNotFoundException e) {
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(e.getMessage())
                        .occuredTime(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OpinionDuplicatedException.class)
    public ResponseEntity<ErrorMessage> handleOpinionDuplicatedException(OpinionDuplicatedException e) {
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(e.getMessage())
                        .occuredTime(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OpinionIllegalValueException.class)
    public ResponseEntity<ErrorMessage> handleOpinionIllegalValueException(OpinionIllegalValueException e) {
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(e.getMessage())
                        .occuredTime(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotAssociatedException.class)
    public ResponseEntity<ErrorMessage> handleUserNotAssociatedException(UserNotFoundException e) {
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(e.getMessage())
                        .occuredTime(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VisitNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleVisitNotFoundException(VisitNotFoundException e) {
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(e.getMessage())
                        .occuredTime(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }
}
