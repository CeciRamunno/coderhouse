package com.proyectofinal.repository;

import com.proyectofinal.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
    /* Optional<Cliente> findByDNI(long dni);
    Optional<Cliente> findByEmail(String email); */
}
