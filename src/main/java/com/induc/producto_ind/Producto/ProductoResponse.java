package com.induc.producto_ind.Producto;

import com.induc.producto_ind.Interfaces.IResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse implements IResponse {
    private int codigo;
    private String mensaje;
    private List<Producto> productos;

}
