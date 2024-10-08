package com.example.technicaltestptsisi.service;

import com.example.technicaltestptsisi.dto.request.LoginRequest;
import com.example.technicaltestptsisi.dto.response.AuthenticationResponse;
import com.example.technicaltestptsisi.dto.request.RegisterUsers;
import com.example.technicaltestptsisi.entity.ERole;
import com.example.technicaltestptsisi.entity.Role;
import com.example.technicaltestptsisi.entity.Users;
import com.example.technicaltestptsisi.exception.EmailExistException;
import com.example.technicaltestptsisi.exception.UsernameExistException;
import com.example.technicaltestptsisi.jwt.JwtUtils;
import com.example.technicaltestptsisi.repository.RoleRepository;
import com.example.technicaltestptsisi.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ValidationService validationService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public AuthenticationResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        String roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .findFirst()
                .orElse("");
        log.info("Login Success");

        return new AuthenticationResponse(userDetails.getId(),
                userDetails.getEmail(),
                roles,
                jwtCookie.getValue());

    }

    public void registerUsers(RegisterUsers registerUsers){
        validationService.validate(registerUsers);
        if(userRepository.existsByEmail(registerUsers.getEmail())){
            log.info("Already Use Email!");
            throw new EmailExistException("Email is already in use");
        }

        if(userRepository.existsByUsername(registerUsers.getUsername())){
            log.info("Already Use Username");
            throw new UsernameExistException("Username is already in use");
        }

        Users users = new Users();
        users.setUsername(registerUsers.getUsername());
        users.setEmail(registerUsers.getEmail());
        users.setPassword(encoder.encode(registerUsers.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role adminRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);
        users.setRoles(roles);
        log.info("Success create account!");
        userRepository.save(users);
    }

    public ResponseCookie logOut(){
        return jwtUtils.getCleanJwtCookie();
    }


}
