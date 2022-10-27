package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer>
{
    Optional<ClienteModel> findById(int id);
}
