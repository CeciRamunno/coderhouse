package com.proyectofinal.repository;

import com.proyectofinal.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository <Stock, Long> {
    /*  Optional<Stock> findByProducto(long idProducto); */
}