package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.repository.DetalleVentaRepository;
import com.proyectofinal.repository.ProductoRepository;
import com.proyectofinal.validators.ProductoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ProductoServiceImpl implements ProductoService
{
    @Autowired
    private ProductoRepository prodRepository;

    @Autowired
    private ProductoValidator prodValidator;

    @Autowired
    private DetalleVentaRepository detVtaRepository;

    @Override
    public Optional<ProductoModel> findProductoById(Long id) throws ResourceNotFoundException {
        this.prodValidator.validateId(id);

        Optional<ProductoModel> producto = this.prodRepository.findById(id);
        if(producto.isPresent())
            return producto;
        else
            throw new ResourceNotFoundException("No existe el producto para el ID " + id + ".");
    }

    @Override
    public ProductoModel findProductoBySku(String sku)
    {
        ProductoModel producto = this.prodRepository.findProductoBySku(sku);
        this.prodValidator.validateBySku(producto);

        return producto;
    }

    @Override
    public List<ProductoModel> findProductos() throws ResourceNotFoundException {
        List<ProductoModel> productos = this.prodRepository.findAll();
        this.prodValidator.validateLista(productos);

        return this.prodRepository.findAll();
    }

    @Override
    /**
     * Para los productos vigentes, considero que al actualizar el precio de venta de un producto (el que está vigente)
     * el precio de venta anterior queda con stock cero.
     */
    public List<ProductoModel> findProductosVigentes() throws ResourceNotFoundException
    {
        List<ProductoModel> productos = this.prodRepository.findAll();
        this.prodValidator.validateLista(productos);

        List<ProductoModel> prodVig = new ArrayList<>();
        for (ProductoModel prod : productos)
        {
            if(prod.getStock() != 0)
                prodVig.add(prod);
        }
        return prodVig;
    }

    @Override
    public String createProducto(ProductoModel newProd) throws ResourceNotFoundException {
        // Valido que el nuevo producto informado no sea null ni que sus campos a completar lo sean.
        prodValidator.validate(newProd);

        // Considero 2 situaciones:
        // Si el producto existe en la base de datos, estamos hablando de una actualización de precio de venta y stock.
        //  Por lo que le doy de baja al existente (le asigno stock 0) y agrego al nuevo (stock existente + nuevo).
        //  Caso contrario lo agrego como nuevo producto a la BD.


        Optional<ProductoModel> productoDB = Optional.ofNullable(this.prodRepository.findProductoBySku(newProd.getSku()));
        if(productoDB.isPresent()) // Ya existe.
        {
            newProd.setStock(newProd.getStock() + productoDB.get().getStock()); // actualizo stock nueva alta.
            newProd.setFechaAlta(LocalDate.now());

            ProductoModel productoABM = productoDB.get();
            productoABM.setStock(0);

            updateProducto(productoABM, productoABM.getId());
        }

        prodRepository.save(newProd);
        return newProd.informeNewProd();
    }

    @Override
    public String updateProducto(ProductoModel producto, Long id) throws ResourceNotFoundException {
        // Valido que no sea null y que tenga sus campos completos.
        prodValidator.validate(producto);

        // Valido que el producto a actualizar esté presente en la BD.
        Optional<ProductoModel> productoDB = this.prodRepository.findById(id);

        if(productoDB.isPresent())
        {
            ProductoModel productoABM = productoDB.get();

            productoABM.setSku(producto.getSku());
            productoABM.setDescripcion(producto.getDescripcion());
            productoABM.setStock(producto.getStock());
            productoABM.setPrecioCompra(producto.getPrecioCompra());
            productoABM.setPrecioVenta(producto.getPrecioVenta());
            productoABM.setFechaAlta(producto.getFechaAlta());

            this.prodRepository.save(productoABM);
            return productoABM.informeProdActualizado();
        }
        else
            throw new ResourceNotFoundException("El producto que desea actualizar no se encuentra en la Base de Datos.");
    }

    @Override
    public String updateStockProd(Long id, int stock, String operador) throws ResourceNotFoundException
    {
        // Valido si el producto existe en la Base de Datos.
        Optional<ProductoModel> producto = this.prodRepository.findById(id);
        if(!producto.isPresent())
            throw new ResourceNotFoundException("No se encontró el producto a actualizarle el Stock en la Base de Datos.");

        // Valido que el stock sea un nro coherente.
        if(stock <= 0)
            throw new IllegalArgumentException("Ingrese un valor positivo para actualizar el stock");

        if(operador.equals("+")) // se suma stock al actual.
            producto.get().setStock((producto.get().getStock() + stock));
        else if(operador.equals("-"))
        {
            if(producto.get().getStock() - stock < 0) {
                throw new IllegalArgumentException("No se puede continuar con la compra.\nNo alcanza el stock de producto " + producto.get().getId() +". Stock actual: " + producto.get().getStock());
            }
            else {
                producto.get().setStock(producto.get().getStock() - stock);
            }
        }
        else
            throw new IllegalArgumentException("El operador informado no es válido. Ingrese \"+\" o \"-\".");

        this.prodRepository.save(producto.get());
        return producto.get().informeProdActualizado();
    }

    @Override
    public String deleteById(Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException {
        if(id == null)
            throw new IllegalArgumentException("No se ingresó ID del producto a eliminar.");

        // Valido si el producto existe en la Base de Datos.
        Optional<ProductoModel> producto = this.prodRepository.findById(id);

        if(!producto.isPresent())
            throw new ResourceNotFoundException("No se encontró el producto a eliminar en la Base de Datos.");

        // Valido que no exista en otras tablas de la Base de Datos.
        List<DetalleVentaModel> lstDetVtasByProdId = detVtaRepository.findDetallesByProdId(id);
        if(!lstDetVtasByProdId.isEmpty() || lstDetVtasByProdId.size() > 0)
            throw new ResourceAlreadyExistsException("El producto no puede eliminarse, puesto que está vinculado en otras tablas.");

        this.prodRepository.deleteById(id);
        return "ok";
    }
}
