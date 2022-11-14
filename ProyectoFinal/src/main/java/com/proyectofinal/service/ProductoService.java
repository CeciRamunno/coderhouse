package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ProductoModel;

import java.util.List;
import java.util.Optional;

public interface ProductoService
{
    public Optional<ProductoModel> findProductoById(Long id) throws ResourceNotFoundException;
    public ProductoModel findProductoBySku(String sku);
    public List<ProductoModel> findProductos() throws ResourceNotFoundException;
    public List<ProductoModel> findProductosVigentes() throws ResourceNotFoundException;
    public String createProducto(ProductoModel newProd) throws ResourceNotFoundException;
    public String updateProducto(ProductoModel producto, Long id) throws ResourceNotFoundException;
    public String updateStockProd(Long id, int stock, String operador) throws ResourceNotFoundException;
    public String deleteById(Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException;
}
