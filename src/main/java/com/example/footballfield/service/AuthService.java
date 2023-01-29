package com.example.footballfield.service;


import com.example.footballfield.entity.User;
import com.example.footballfield.enums.ErrorCode;
import com.example.footballfield.enums.Role;
import com.example.footballfield.exception.GenericException;
import com.example.footballfield.model.UserDto;
import com.example.footballfield.model.request.LoginRequest;
import com.example.footballfield.model.request.SignUpRequest;
import com.example.footballfield.model.response.TokenResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;
    private final PasswordEncoder encoder;

    public AuthService(AuthenticationManager authenticationManager, UserService userService, TokenService tokenService, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenService = tokenService;
        this.encoder = encoder;
    }

    public TokenResponseDto login(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return new TokenResponseDto(tokenService.generateToken(auth),userService.findUser(loginRequest.getUsername()));

        } catch (final BadCredentialsException badCredentialsException) {
            throw new GenericException("Invalid Username or Password",HttpStatus.NOT_FOUND);
        }
    }


    @Transactional
    public UserDto signup(SignUpRequest signUpRequest){
        var isAllReadyRegistered = userService.existsByUsername(signUpRequest.getUsername());

        if(isAllReadyRegistered) {
            throw new GenericException("Username " + signUpRequest.getUsername() + " is alread used",HttpStatus.FOUND);
        }
        var user = new
                com.example.footballfield.entity.User(null, LocalDateTime.now(),LocalDateTime.now(),
                signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()),signUpRequest.getRole());

        User fromDb = userService.create(user);
        return UserDto.converToUserDto(fromDb);
    }

}
