package com.induc.producto_ind.Categoria;

import com.induc.producto_ind.Interfaces.IResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoria(String id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
    }

    public CategoriaResponse addCategoria(Categoria categoria) {

        try{
            System.out.println(categoria.getId());
            if(categoriaRepository.existsById(categoria.getId().toLowerCase(Locale.ROOT))){
                throw new IllegalArgumentException("Categoria existente");
            }
            Categoria newCategoria = Categoria.builder()
                    .id(categoria.getId().toLowerCase(Locale.ROOT))
                    .descripcion(categoria.getDescripcion())
                    .build();
            categoriaRepository.save(newCategoria);
            return new CategoriaResponse("Categoria creada con exito",201);
        }catch (Exception e){
            return new CategoriaResponse("Error al crear categoria: "+e.getMessage(),500);
        }
    }
}
