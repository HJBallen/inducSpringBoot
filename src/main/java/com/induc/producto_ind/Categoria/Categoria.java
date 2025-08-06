package com.induc.producto_ind.Categoria;

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
@Table(name = "categoria")
public class Categoria {
    @Id
    String id;
    @Column(length = 255, nullable = false)
    String descripcion;

}
