package com.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clientes")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    public String informeNewCliente()
    {
        return String.format("Cliente creado:%nID: %d | DNI: %s | Nombre y apellido: %s %s | Fecha Nacimiento: %s.%n",
                this.id, this.dni, this.nombre, this.apellido, this.fechaNacimiento);
    }

    public String informeCliActualizado()
    {
        return String.format("Cliente de ID %d actualizado:%nDNI: %s | Nombre y apellido: %s %s | Fecha Nacimiento: %s.%n",
                this.id, this.dni, this.nombre, this.apellido, this.fechaNacimiento);
    }
}
