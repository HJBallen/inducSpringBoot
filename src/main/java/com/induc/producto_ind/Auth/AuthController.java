package com.induc.producto_ind.Auth;

import com.induc.producto_ind.Interfaces.IResponse;
import com.induc.producto_ind.User.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value="/login")
    public ResponseEntity<IResponse> login(@RequestBody LoginRequest request) {
        try{
            return ResponseEntity.ok(authService.login(request));
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return ResponseEntity.status(500).body(new AuthResponse(ex.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<IResponse> register(@RequestBody UserRegisterRequest user) {
        try{
            return ResponseEntity.ok(authService.register(user));
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return ResponseEntity.status(500).body(new AuthResponse(ex.getMessage()));
        }



    }

}
