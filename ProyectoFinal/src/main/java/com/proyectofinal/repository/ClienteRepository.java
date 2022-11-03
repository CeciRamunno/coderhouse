package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer>
{
    Optional<ClienteModel> findClienteyId(int id);
}
