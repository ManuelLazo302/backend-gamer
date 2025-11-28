package com.example.productos.controller;

import com.example.productos.model.Producto;
import com.example.productos.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
@Tag(name = "Products", description = "Product Management System")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "View a list of available products")
    public List<Producto> getAllProducts(){
        return productoService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Product by id")
    public Producto getproductById(@PathVariable Long id){
        return productoService.getProductById(id);
    }

    @PostMapping
    @Operation(summary = "Add a new Product")
    public Producto createProduct(@RequestBody Producto producto){
        return productoService.saveProduct(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Product")
    public Producto updateProduct(@PathVariable Long id, @RequestBody Producto producto){
        Producto existingProduct = productoService.getProductById(id);
        if (existingProduct != null) {
            existingProduct.setId(producto.getId());
            existingProduct.setName(producto.getName());
            existingProduct.setPrice(producto.getPrice());
            existingProduct.setImage(producto.getImage());
            existingProduct.setCategory(producto.getCategory());
            existingProduct.setDesc(producto.getDesc());
            return productoService.saveProduct(existingProduct);
        }
        return null;
    }

    @DeleteMapping
    @Operation(summary = "Delete a Product")
    public void deleteProduct(@PathVariable Long id){
        productoService.deleteProducto(id);
    }
}