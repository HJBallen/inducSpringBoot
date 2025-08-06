package com.induc.producto_ind.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
}
