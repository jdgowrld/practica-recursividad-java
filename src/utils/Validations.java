package utils;

import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 */
public class Validations {
    public static int requestPositiveInteger(Scanner scanner, String message) {
        int number = -1;
        while (number < 0) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                number = Integer.parseInt(input);

                if (number < 0) {
                    System.out.println("Error: No metas números negativos. (mayor o igual a 0).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Ingresa un número entero válido.");;
            }
        }
        return number;
    }
}