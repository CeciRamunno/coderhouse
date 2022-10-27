package com.proyectofinal.controller;

import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.service.ProductoService;
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
    private ProductoService prodSvc;

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

    @PostMapping("/postAltaProducto")
    public ResponseEntity<ProductoModel> altaProducto(@RequestBody ProductoModel newProd)
    {
        return new ResponseEntity<>(prodSvc.altaProducto(newProd), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductoModel> updateProd(@RequestBody ProductoModel prodABM, @PathVariable int id)
    {
        return new ResponseEntity<>(prodSvc.update(prodABM, id), HttpStatus.OK);
    }
}
