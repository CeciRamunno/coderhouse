package DesafioListarPersonas;

import java.util.Comparator;

/**
 * Deberán crear la clase persona que tiene como atributos nombre y apellido, ambos de tipo String;
 * la clase tiene sus métodos getters y setters para cada atributo.
 */
public class Persona
{
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
