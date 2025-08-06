package com.induc.producto_ind.Producto;

import com.induc.producto_ind.Categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue
    int id;
    @Column(length = 100, nullable = false)
    String nombre;
    @Column(length = 255, nullable = false)
    String descripcion;
    @Column(length = 255, nullable = false)
    String imagen;
    @Column(length = 50, nullable = false)
    String idCategoria;
}
