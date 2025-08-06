package com.induc.producto_ind.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private String imagen;
    private String categoria;
}
