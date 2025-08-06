package com.induc.producto_ind.Categoria;

import com.induc.producto_ind.Interfaces.IResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse implements IResponse {
    private String mensaje;
    private int codigo;
}
