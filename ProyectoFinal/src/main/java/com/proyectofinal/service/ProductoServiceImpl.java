package com.proyectofinal.service;

import com.proyectofinal.exceptions.IllegalArgumentException;
import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.repository.ProductoRepository;
import com.proyectofinal.validators.ProductoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl
{
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoValidator prodValidador;

    public Optional<ProductoModel> findById(int id)
    {
        return productoRepository.findById(id);
    }

    public List<ProductoModel> findAll()
    {
        return productoRepository.findAll();
    }

    public ProductoModel create(ProductoModel newProd) throws ResourceAlreadyExistsException, IllegalArgumentException {
        this.prodValidador.validate(newProd);

        Optional<ProductoModel> prodBD = this.productoRepository.findBySku(newProd.getSku());
        if(prodBD.isPresent())
            throw new ResourceAlreadyExistsException("El producto que se desea crear ya existe en la BD: " + newProd.toString());
        else
            return this.productoRepository.save(newProd);
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
