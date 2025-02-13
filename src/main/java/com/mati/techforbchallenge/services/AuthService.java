package com.mati.techforbchallenge.services;

import com.mati.techforbchallenge.controllers.AuthResponse;
import com.mati.techforbchallenge.controllers.LoginRequest;
import com.mati.techforbchallenge.controllers.RegisterRequest;
import com.mati.techforbchallenge.entities.Role;
import com.mati.techforbchallenge.entities.UserRepository;
import com.mati.techforbchallenge.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest registerRequest) {

        Usuario user = Usuario.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .role(Role.USER)
                .build();

        usuarioRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}
