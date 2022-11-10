package com.proyectofinal.controller;

import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.service.ProductoServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController
{
    @Autowired
    private ProductoServiceImpl prodSvc;

    @GetMapping(value = "/getProductoById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductoById(@PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(prodSvc.findProductoById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getTodos")
    public ResponseEntity<List<ProductoModel>> findAllProductos()
    {
        return new ResponseEntity<>(prodSvc.findProductos(), HttpStatus.OK);
    }

    @PostMapping(value = "/postNewProducto")
    public ResponseEntity<ProductoModel> createProducto(@RequestBody ProductoModel newProd)
    {
        return new ResponseEntity<>(prodSvc.createProducto(newProd),HttpStatus.OK);
    }

    @PutMapping(value = "/putUpdateProducto/{id}")
    public ResponseEntity<ProductoModel> updateProducto(@RequestBody ProductoModel producto, @PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(prodSvc.updateProducto(producto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") long id)
    {
        prodSvc.deleteById(id);
        return new ResponseEntity<>("Producto de id " + id + " fue eliminado.", HttpStatus.OK);
    }

    // TODO: agregar para actualizar precio (nuevo input).
}
