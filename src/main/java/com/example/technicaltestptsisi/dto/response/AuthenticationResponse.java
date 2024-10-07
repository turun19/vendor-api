package com.example.technicaltestptsisi.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private Long id;
    private String email;
    private String roles;
    private String jwt;

    public AuthenticationResponse(Long id, String email, String roles, String jwt) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.jwt = jwt;
    }
}
