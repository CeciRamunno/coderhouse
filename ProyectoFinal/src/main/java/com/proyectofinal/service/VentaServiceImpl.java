package com.proyectofinal.service;

import com.proyectofinal.dto.DetalleVentaDto;
import com.proyectofinal.dto.VentaDto;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.model.VentaModel;
import com.proyectofinal.repository.VentaRepository;
import com.proyectofinal.validators.VentaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService
{
    @Autowired
    private VentaRepository vtaRepository;

    @Autowired
    private ClienteServiceImpl cliSvc;

    @Autowired
    private ProductoServiceImpl prodSvc;

    @Autowired
    private DetalleVentaServiceImpl detalleSvc;

    @Autowired
    private VentaValidator ventaValidator;

    @Override
    public Optional<VentaModel> findVentaById(Long id) throws ResourceNotFoundException {
        ventaValidator.validateId(id);

        Optional<VentaModel> venta = this.vtaRepository.findById(id);
        if(venta.isPresent())
            return venta;
        else
            throw new ResourceNotFoundException("No existe venta para ese ID " + id + ".");
    }

    @Override
    public List<DetalleVentaModel> findVentaConDetalleById(Long vtaId) throws ResourceNotFoundException {
        return detalleSvc.findDetallesByVtaId(vtaId);
    }

    @Override
    public List<VentaModel> findVentas() throws ResourceNotFoundException {
        List<VentaModel> ventas = this.vtaRepository.findAll();
        this.ventaValidator.validateLista(ventas);

        return ventas;
    }

    @Override
    public List<VentaModel> findVentasByClienteId(Long idCliente) throws ResourceNotFoundException {
        Optional<ClienteModel> cliente = cliSvc.findClienteById(idCliente);
        if(cliente.isPresent())
            return this.vtaRepository.findVentasByClienteId(idCliente);
        else
            throw new ResourceNotFoundException("No se encontró el cliente en la Base de Datos.");
    }

    @Override
    public VentaModel createVenta(VentaDto newVentaDto) throws ResourceNotFoundException
    {
        ClienteModel cliente = this.cliSvc.findClienteById(newVentaDto.getIdCliente()).get();

        // Valido info de entrada de la venta.
        ventaValidator.validateDTO(newVentaDto);

        // Genero la venta:
        Double total = 0.0;
        VentaModel venta = new VentaModel(LocalDate.now(), total, cliente);
        venta = this.vtaRepository.save(venta);

        for (DetalleVentaDto dvDto : newVentaDto.getDetalles())
        {
            ProductoModel producto = this.prodSvc.findProductoById(dvDto.getProductoId()).get();
            Double subtotal = dvDto.getCantidad() * producto.getPrecioVenta();

            // Actualizo stock del producto.
            this.prodSvc.updateStockProd(producto.getId(), dvDto.getCantidad(), "-");

            DetalleVentaModel dv = new DetalleVentaModel(venta, producto, dvDto.getCantidad(), subtotal);
            this.detalleSvc.createDetalleVenta(dv);

            total += subtotal;
        }
        venta.setTotal(total);
        return updateVenta(venta, venta.getId());
    }

    @Override
    public VentaModel updateVenta(VentaModel venta, Long id) throws ResourceNotFoundException {
        // Valido que no sea null y que sus campos obligatorios estén completos.
        Optional<VentaModel> ventaDB = this.vtaRepository.findById(id);
        ventaValidator.validate(venta);

        // Valido que la venta a actualizar esté en la Base de Datos.
        if(ventaDB.isPresent())
        {
            VentaModel ventaABM = ventaDB.get();

            ventaABM.setClienteId(venta.getClienteId());
            ventaABM.setTotal(venta.getTotal());
            ventaABM.setFechaAlta(venta.getFechaAlta());

            return this.vtaRepository.save(ventaABM);
        }
        else
            throw new ResourceNotFoundException("La venta no se encuentra registrada en la Base de Datos.");
    }
}
