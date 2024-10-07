package com.example.technicaltestptsisi.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoResponse {
    private Long id;
    private String email;
    private String roles;
    private String token;

    public UserInfoResponse(Long id, String email, String roles, String token) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.token = token;
    }
}
