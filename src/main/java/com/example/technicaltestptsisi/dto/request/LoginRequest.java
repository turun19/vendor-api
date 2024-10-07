package com.example.technicaltestptsisi.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class LoginRequest {
    @Email
    private String email;
    private String password;
}
