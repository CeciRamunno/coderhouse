package com.proyectofinal.controller;

import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/detalleVenta")
@RestController
public class DetalleVentaController
{
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/getDetalleVentaById")
    public Optional<DetalleVentaModel> findById(int id)
    {
        return detalleVentaService.findById(id);
    }

    @GetMapping("/getDetalleVentas")
    public ResponseEntity<List<DetalleVentaModel>> findAll()
    {
        return new ResponseEntity<>(detalleVentaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/postNuevoDetalleVenta")
    public ResponseEntity<DetalleVentaModel> nuevoDetalleVenta(@RequestBody DetalleVentaModel nuevoDetVenta)
    {
        return new ResponseEntity<>(detalleVentaService.nuevoDetalleVta(nuevoDetVenta), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<DetalleVentaModel> updateDetalleVenta(@RequestBody DetalleVentaModel detalleVtaABM, @PathVariable int id)
    {
        return new ResponseEntity<>(detalleVentaService.update(detalleVtaABM, id), HttpStatus.OK);
    }


}