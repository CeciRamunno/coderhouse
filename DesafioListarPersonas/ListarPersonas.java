package DesafioListarPersonas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Deberán crear una segunda clase donde estará el método main como lo conocemos.
 * Creen 5 objetos: Personas con nombres y apellidos aleatorios, es importante que sean nombres y apellidos en español.
 */
public class ListarPersonas
{
    public static void main(String[] args)
    {
        Persona p1 = new Persona("Juan", "Perez");
        Persona p2 = new Persona("Maria", "Gomez");
        Persona p3 = new Persona("Jose", "Fernandez");
        Persona p4 = new Persona("Cecilia", "Rodriguez");
        Persona p5 = new Persona("Pablo", "Hernandez");

        // Teniendo los 5 objetos, agregarlos a una lista.
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);
        listaPersonas.add(p5);

        // Crear la lógica para ordenar alfabéticamente la lista y mostrar en consola de acuerdo al siguiente criterio:
        // Ordenado por nombre.
        System.out.println("Lista de personas ordenadas por Nombre");
        Collections.sort(listaPersonas, Comparator.comparing(Persona::getNombre));
        listaPersonas.forEach(System.out::println);
        System.out.println(System.lineSeparator());

        //Ordenado por apellido.
        System.out.println("Lista de personas ordenadas por Apellido");
        Collections.sort(listaPersonas, Comparator.comparing(Persona::getApellido));
        listaPersonas.forEach(System.out::println);
        System.out.println(System.lineSeparator());

        //Ordenado inversamente por apellido.
        System.out.println("Lista de personas ordenadas por Apellido por orden inverso");
        Collections.sort(listaPersonas, Comparator.comparing(Persona::getApellido).reversed());
        listaPersonas.forEach(System.out::println);
        System.out.println(System.lineSeparator());
    }
}
