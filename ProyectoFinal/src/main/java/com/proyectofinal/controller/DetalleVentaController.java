package com.proyectofinal.controller;

import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.service.DetalleVentaServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/detalle")
public class DetalleVentaController
{
    @Autowired
    private DetalleVentaServiceImpl detalleSvc;

    @GetMapping(value = "/getDetalleVentaById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getDetalleById(@PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(detalleSvc.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<List<DetalleVentaModel>> findAllDetalles()
    {
        return new ResponseEntity<>(detalleSvc.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/postNewDetalle")
    public ResponseEntity<DetalleVentaModel> createDetalle(@RequestBody DetalleVentaModel newDetalle)
    {
        return new ResponseEntity<>(detalleSvc.createDetalleVenta(newDetalle),HttpStatus.OK);
    }
}
