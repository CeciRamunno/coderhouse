package com.proyectofinal.controller;

import com.proyectofinal.exceptions.IllegalArgumentException;
import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/producto")
@RestController
public class ProductoController
{
    @Autowired
    private ProductoServiceImpl prodSvc;

    @GetMapping("/getProdById")
    public Optional<ProductoModel> findById(int id)
    {
        return this.prodSvc.findById(id);
    }

    @GetMapping("/getProductos")
    public ResponseEntity<List<ProductoModel>> findAll()
    {
        return new ResponseEntity<>(this.prodSvc.findAll(), HttpStatus.OK);
    }

    @PostMapping("/postCreateProducto")
    public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel newProd) throws ResourceAlreadyExistsException, IllegalArgumentException {
        return new ResponseEntity<>(prodSvc.create(newProd), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductoModel> updateProd(@RequestBody ProductoModel prodABM, @PathVariable int id)
    {
        return new ResponseEntity<>(prodSvc.update(prodABM, id), HttpStatus.OK);
    }
}
