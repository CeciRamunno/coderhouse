package com.proyectofinal.validators;

import com.proyectofinal.exceptions.IllegalArgumentException;
import com.proyectofinal.model.ProductoModel;

public class ProductoValidator
{
    public void validate(ProductoModel producto) throws IllegalArgumentException {
        if(producto == null)
            throw new IllegalArgumentException("Producto que intenta crear es nulo o vacío.");

//        getStock < 0 getPriceBuy < 0 getPriceSell < 0 StringUtils.isBlank(producto.getDescripcion) idem para sku

    }
}
