package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>
{
//    @Query(value = "Select * from clientes where id i= ?1", nativeQuery = true)
//    public ClienteModel findClienteById(long id);
//
//    @Query(value = "Select * from clientes", nativeQuery = true)
//    public List<ClienteModel> findAllClientes();
}
