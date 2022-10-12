package com.proyectofinal.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CLIENTES")
public class Cliente
{
    @Id
    @Column(name = "DNI")
    private long dni;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "EMAIL")
    private String email;
}
