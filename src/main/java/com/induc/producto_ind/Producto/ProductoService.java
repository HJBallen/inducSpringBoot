package com.induc.producto_ind.Producto;

import com.induc.producto_ind.Categoria.Categoria;
import com.induc.producto_ind.Categoria.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductosRepository productoRepo;
    private final CategoriaService categoriaService;

    public ProductoResponse getListaProductos(){
        try{
            return ProductoResponse.builder()
                    .codigo(200)
                    .mensaje("Consulta realizada con exito")
                    .productos(productoRepo.findAll()).build();
        }catch(Exception e){
            return  ProductoResponse.builder()
                    .codigo(500)
                    .mensaje("Error al obtener la lista de productos")
                    .build();
        }
    }

    public ProductoResponse addProducto(ProductoRequest request) {
        try {
            Categoria categoria = categoriaService.getCategoria(request.getCategoria().toLowerCase(Locale.ROOT));
            Producto newProducto = Producto.builder()
                    .nombre(request.getNombre())
                    .descripcion(request.getDescripcion())
                    .idCategoria(categoria.getId())
                    .imagen(request.getImagen())
                    .build();
            System.out.println(categoria.getId());
            productoRepo.save(newProducto);
            return new ProductoResponse(201, "Producto creado con exito", null);
        }catch (Exception e){
            return new ProductoResponse(500, "Error al crear el producto: " + e.getMessage(), null);
        }
    }

    public ProductoResponse deactivate(int id) {
        try {
            return new ProductoResponse(202, "Producto desactivado con exito", null);
        } catch (Exception e) {
            return  new ProductoResponse(500, "Error al desactivar el producto", null);
        }

    }
}
