package com.proyectofinal.controller;

import com.proyectofinal.dto.VentaDto;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.model.VentaModel;
import com.proyectofinal.service.VentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/venta")
public class VentaController {
    @Autowired
    private VentaServiceImpl vtaSvc;

    @GetMapping(value = "/getVentaById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getVentaById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(vtaSvc.findVentaById(id), HttpStatus.OK);
    }

   @GetMapping(value = "/getVentaDetallesById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
   public ResponseEntity<List<DetalleVentaModel>> getVentaDetalleById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
       return new ResponseEntity<>(vtaSvc.findVentaConDetalleById(id), HttpStatus.OK);
   }

   @GetMapping(value = "/getVentasByClienteId/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
   public ResponseEntity<List<VentaModel>> findVentasByClienteId(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
       return new ResponseEntity<>(vtaSvc.findVentasByClienteId(id), HttpStatus.OK);
   }

   @GetMapping(value = "/getTodas")
   public ResponseEntity<List<VentaModel>> findAllVentas() throws ResourceNotFoundException {
        return new ResponseEntity<>(vtaSvc.findVentas(), HttpStatus.OK);
    }

//    /**
//     * Para realizar venta, precisamos idCliente y los items comprados.
//     * El total de la Venta se calcula con los subtotales.
//     * El id de la Venta y la fecha se agregarán automáticamente.
//     * @param newVta
//     * @param detsNewVta
//     * @return
//     */
    @PostMapping(value = "/postNewVta")
    public ResponseEntity<VentaModel> createVta(@RequestBody VentaDto newVenta) throws ResourceNotFoundException {
        return new ResponseEntity<>(vtaSvc.createVenta(newVenta), HttpStatus.OK);
    }
}
