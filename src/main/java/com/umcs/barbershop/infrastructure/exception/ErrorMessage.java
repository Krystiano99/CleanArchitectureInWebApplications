package com.umcs.barbershop.infrastructure.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private String message;
    private HttpStatus status;
    private LocalDateTime occuredTime;
}
