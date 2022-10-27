package com.proyectofinal.controller;

import com.proyectofinal.model.VentaModel;
import com.proyectofinal.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/venta")
@RestController
public class VentaController
{
    @Autowired
    private VentaService ventaService;

    @GetMapping("/getVentaById")
    public Optional<VentaModel> findById(int id)
    {
        return ventaService.findById(id);
    }

    @GetMapping("/getVentas")
    public ResponseEntity<List<VentaModel>> findAll()
    {
        return new ResponseEntity<>(ventaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/postNuevaVenta")
    public ResponseEntity<VentaModel> nuevaVenta(@RequestBody VentaModel nuevaVenta)
    {
        return new ResponseEntity<>(ventaService.nuevaVenta(nuevaVenta), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<VentaModel> updateVenta(@RequestBody VentaModel vtaABM, @PathVariable int id)
    {
        return new ResponseEntity<>(ventaService.update(vtaABM, id), HttpStatus.OK);
    }



}
