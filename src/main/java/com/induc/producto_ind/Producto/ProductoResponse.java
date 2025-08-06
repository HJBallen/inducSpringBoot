package com.induc.producto_ind.Producto;

import com.induc.producto_ind.Interfaces.IResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse implements IResponse {
    private int codigo;
    private String mensaje;

}
