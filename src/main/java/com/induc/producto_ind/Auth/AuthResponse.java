package com.induc.producto_ind.Auth;

import com.induc.producto_ind.Interfaces.IResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse implements IResponse {
    String token;
}
