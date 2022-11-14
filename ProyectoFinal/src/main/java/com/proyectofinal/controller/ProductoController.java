package com.proyectofinal.controller;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.service.ProductoServiceImpl;
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
    public ResponseEntity<?> getProductoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(prodSvc.findProductoById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getProductoBySku/{sku}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductoBySku(@PathVariable(name = "sku") String sku)
    {
        return new ResponseEntity<>(prodSvc.findProductoBySku(sku), HttpStatus.OK);
    }

    @GetMapping(value = "/getTodos")
    public ResponseEntity<List<ProductoModel>> findAllProductos() throws ResourceNotFoundException {
        return new ResponseEntity<>(prodSvc.findProductos(), HttpStatus.OK);
    }

    @GetMapping(value = "/getProductosVigentes")
    public ResponseEntity<List<ProductoModel>> findAllProductosVigentes() throws ResourceNotFoundException {
        return new ResponseEntity<>(prodSvc.findProductosVigentes(), HttpStatus.OK);
    }

    @PostMapping(value = "/postNewProducto")
    public ResponseEntity<String> createProducto(@RequestBody ProductoModel newProd) throws ResourceNotFoundException {
        return new ResponseEntity<>(prodSvc.createProducto(newProd),HttpStatus.OK);
    }

    @PutMapping(value = "/putUpdateProducto/{id}")
    public ResponseEntity<String> updateProducto(@RequestBody ProductoModel producto, @PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(prodSvc.updateProducto(producto, id), HttpStatus.OK);
    }

//    @PutMapping(value = "/updateStockProd")
//    public ResponseEntity<String> updateStock(@PathVariable(name = "id") Long id, @PathVariable(name = "movimientoStock") Integer movimientoStock, @PathVariable(name = "operador") String operador) throws ResourceNotFoundException {
//        return new ResponseEntity<>(prodSvc.updateStockProd(id, movimientoStock, operador), HttpStatus.OK);
//    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") long id) throws ResourceAlreadyExistsException, ResourceNotFoundException {
        String rtado = prodSvc.deleteById(id);
        if(rtado.equals("ok"))
            return new ResponseEntity<>("Producto de id " + id + " fue eliminado.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Error al eliminar cliente de id " + id + ".", HttpStatus.BAD_REQUEST);
    }
}
