package com.example.technicaltestptsisi.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterUsers {
    @NotEmpty(message = "Must Not Empty")
    private String username;
    @Email
    private String email;
    @NotEmpty(message = "Must Not Empty")
    private String password;
}
