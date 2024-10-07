package com.example.technicaltestptsisi.controller;

import com.example.technicaltestptsisi.dto.request.LoginRequest;
import com.example.technicaltestptsisi.dto.request.RegisterUsers;
import com.example.technicaltestptsisi.dto.response.AuthenticationResponse;
import com.example.technicaltestptsisi.dto.response.BaseResponse;
import com.example.technicaltestptsisi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @SecurityRequirements
    @Operation(summary = "User Login for get JWT Token")
    public ResponseEntity<BaseResponse<AuthenticationResponse>> signIn(@Valid @RequestBody LoginRequest loginRequest){
        AuthenticationResponse authenticationResponse = authService.loginUser(loginRequest);
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, authenticationResponse.getJwt())
                .body(BaseResponse.success(authenticationResponse, "Berhasil Login"));


    }

    @PostMapping("/signup")
    @SecurityRequirements
    @Operation(summary = "User register for create account")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterUsers signUpRequest) {
        authService.registerUsers(signUpRequest);
        return ResponseEntity.ok(BaseResponse.success(null, "Berhasil Register"));
    }

    @PostMapping("/logout")
    @Operation(summary = "For logout account user")
    public ResponseEntity<BaseResponse<?>> logout() {
        ResponseCookie responseCookie = authService.logOut();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(BaseResponse.success(null, "Berhasil Logout"));
    }
}
