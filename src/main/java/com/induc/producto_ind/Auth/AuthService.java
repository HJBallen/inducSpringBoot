package com.induc.producto_ind.Auth;

import com.induc.producto_ind.JWT.JwtService;
import com.induc.producto_ind.User.UserRegisterRequest;
import com.induc.producto_ind.User.User;
import com.induc.producto_ind.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = userRepo.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.getToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse register(UserRegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .nombre(registerRequest.getNombre())
                .apellido(registerRequest.getApellido())
                .fecha_registro(new Date())
                .build();

        userRepo.save(user);
        return new AuthResponse(jwtService.getToken(user));
    }

}
