package com.umcs.barbershop.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    String firstName;
    String lastName;
    String login;
    String password;
    String email;
    String phoneNumber;
    String role;

}
