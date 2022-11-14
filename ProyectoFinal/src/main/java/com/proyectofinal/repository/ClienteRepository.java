package com.proyectofinal.repository;

import com.proyectofinal.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>
{
    @Query(value = "Select * from Clientes where dni = ?1", nativeQuery = true)
    public ClienteModel findClienteByDNI(String dni);
}
