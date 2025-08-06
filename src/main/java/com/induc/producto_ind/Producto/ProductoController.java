package com.induc.producto_ind.Producto;

import com.induc.producto_ind.Interfaces.IResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping(value = "/welcome")
    public String demo() {
        return "Welcome to Productos Api";
    }

    @GetMapping("")
    public ResponseEntity<List<Producto>> getProductos(){
        return ResponseEntity.ok(productoService.getListaProductos());
    }

    public String getProductosPorCategria(){
        return "Productos por categoria";
    }

    @PostMapping("/create")
    public ResponseEntity<IResponse> postProducto(@RequestBody ProductoRequest producto){
        ProductoResponse res = productoService.addProducto(producto);

        return ResponseEntity.status(res.getCodigo()).body(res);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<IResponse> deactivateProducto(@PathVariable int id){
        ProductoResponse res = productoService.deactivate(id);
        return ResponseEntity.status(res.getCodigo()).body(res);
    }
}
