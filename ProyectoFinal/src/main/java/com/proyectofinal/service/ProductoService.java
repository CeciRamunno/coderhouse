package com.proyectofinal.service;

import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;

    public Optional<ProductoModel> findById(int id)
    {
        return productoRepository.findById(id);
    }

    public List<ProductoModel> findAll()
    {
        return productoRepository.findAll();
    }

    public ProductoModel altaProducto(ProductoModel newProd)
    {
        return productoRepository.save(newProd);
    }

    public ProductoModel update(ProductoModel producto, int id)
    {
        Optional<ProductoModel> productoBD = productoRepository.findById(id);
        if(productoBD.isPresent())
        {
            ProductoModel prodABM = productoBD.get();

            prodABM.setId(producto.getId());
            prodABM.setDescripcion(producto.getDescripcion());
            prodABM.setSku(producto.getSku());
            prodABM.setPrecioCompra(producto.getPrecioCompra());
            prodABM.setPrecioVenta(producto.getPrecioVenta());
            prodABM.setStock(producto.getStock());
            prodABM.setFechaAlta(producto.getFechaAlta());

            return productoRepository.save(prodABM);
        }

        return null;
    }

    public void deleteById(int id)
    {
        productoRepository.deleteById(id);
    }
}
