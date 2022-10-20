package com.clienteapirest.repository;

import com.clienteapirest.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>
{

}
