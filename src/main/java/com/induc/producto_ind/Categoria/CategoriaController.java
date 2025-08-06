package com.induc.producto_ind.Categoria;

import com.induc.producto_ind.Interfaces.IResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping("")
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

    @PostMapping("/create")
    public ResponseEntity<IResponse> addCategoria(@RequestBody Categoria categoria){
        CategoriaResponse res = categoriaService.addCategoria(categoria);
        return ResponseEntity.status(res.getCodigo()).body(res);
    }
}
