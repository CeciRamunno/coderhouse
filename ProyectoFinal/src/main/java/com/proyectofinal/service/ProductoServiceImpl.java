package com.proyectofinal.service;

import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl
{
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoModel findProductoById(Long id)
    {
        return this.productoRepository.findProductoById(id);
    }

    public List<ProductoModel> findProductos()
    {
        return this.productoRepository.findAll();
    }

    public ProductoModel createProducto(ProductoModel newProd)
    {
        return this.productoRepository.save(newProd);
    }

    public ProductoModel updateProducto(ProductoModel producto, Long id)
    {
        Optional<ProductoModel> productoDB = this.productoRepository.findById(id);

        if(productoDB.isPresent())
        {
            ProductoModel productoABM = productoDB.get();

            productoABM.setSku(producto.getSku());
            productoABM.setDescripcion(producto.getDescripcion());
            productoABM.setPrecioCompra(producto.getPrecioCompra());
            productoABM.setPrecioVenta(producto.getPrecioVenta());
            productoABM.setFechaAlta(producto.getFechaAlta());

            return this.productoRepository.save(productoABM);
        }

        return null;
    }

    public void deleteById(Long id)
    {
        //TODO: validarq exista antes.
        this.productoRepository.deleteById(id);
    }
}
