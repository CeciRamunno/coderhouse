package com.proyectofinal.validators;

import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ProductoModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProductoValidator
{
    public void validate(ProductoModel producto){
        if(producto == null)
            throw new IllegalArgumentException("No hay valores para producto.");

        if(producto.getSku().isBlank() || producto.getDescripcion().isBlank() || producto.getStock() == null || producto.getPrecioCompra() == null || producto.getPrecioVenta() == null || producto.getFechaAlta().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Faltan completar datos del producto.");

    }
    public void validateId(Long id)
    {
        if(id == null || id < 0)
            throw new IllegalArgumentException("Ingrese un ID válido.");
    }

    public void validateBySku(ProductoModel producto)
    {
        if(producto == null)
            throw new IllegalArgumentException("No existe un producto con ese SKU.");
    }

    public void validateLista(List<ProductoModel> productos) throws ResourceNotFoundException {
        if(productos == null || productos.isEmpty() || productos.size() == 0)
            throw new ResourceNotFoundException("No hay productos cargados en la BD.");
    }
}
