/*
package com.proyectofinal.service;

import com.proyectofinal.entities.Cliente;
import com.proyectofinal.entities.Producto;
import com.proyectofinal.entities.Venta;
import com.proyectofinal.repository.ClienteRepository;
import com.proyectofinal.repository.ProductoRepository;
import com.proyectofinal.repository.StockRepository;
import com.proyectofinal.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class facturacionService
{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private StockRepository stockRepository;

    public List<Producto> findAllProductos()
    {
        return productoRepository.findAll();
    }

    public List<Cliente> findAllClientes()
    {
        return clienteRepository.findAll();
    }

    public List<Venta> findAllVentas()
    {
        return ventaRepository.findAll();
    }

    // Validacion info de entrada
    public String findByDNI(long dni) throws Exception
    {
        return this.clienteRepository.findByDNI(dni).isPresent() ? "Cliente no existe en la base." : "Usuario nuevo";
    }
}
*/