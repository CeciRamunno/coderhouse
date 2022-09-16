package Desafio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio1
{
    public static void main(String[] args)
    {
        // Primero solicito al usuario que ingrese un numero por terminal.
        System.out.println("Ingrese número con decimal:");
        Scanner scanner = new Scanner(System.in);

        try {
            float numero = scanner.nextFloat();

            // Tomo parte entera del numero:
            int parteEntera = (int) numero;
            System.out.println("La parte entera del número que ingresaste es: " + parteEntera);
            float parteDecimal = numero - parteEntera;
            System.out.println("Y la parte decimal es: " + parteDecimal);
            System.out.println("Fin del programa.");
        }
        catch (InputMismatchException e) {
            System.out.println("Sólo puedes ingresar números. Vuelve a iniciar el programa");
        }
    }
}
