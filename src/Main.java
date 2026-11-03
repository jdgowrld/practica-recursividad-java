import dtos.MetricsResults;
import logics.MathLogics;
import utils.Validations;

import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 */
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int option = 0;
        while (option != 5) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. MCD");
            System.out.println("4. Credits");
            System.out.println("5. Exit");

            option = Validations.requestPositiveInteger(read, "Elija una opcion: ");

            switch (option) {
                case 1:
                    handleFactorial(read);
                    break;
                case 2:
                    handleFibonacci(read);
                    break;
                case 3:
                    handleMCD(read);
                    break;
                case 4:
                    showCredits();
                    break;
                case 5:
                    System.out.println("Hasta luego... ");
                    break;
                default:
                    System.out.println("Opcion no valida. Escoja del 1 al 5");
            }
        }
        read.close();
    }

    private static void handleFactorial(Scanner read) {
        System.out.println("--- CALCULAR FACTORIAL ---");
        int num = Validations.requestPositiveInteger(read, "Ingrese un numero entero positivo: ");

        MetricsResults iterativeResult = MathLogics.iterativeFactorial(num);
        printMetrics("--- FACTORIAL ITERATIVO ---", iterativeResult);

        MetricsResults recursiveResult = MathLogics.recursiveFactorial(num);
        printMetrics("--- FACTORIAL RECURSIVO ---", recursiveResult);
    }

    private static void handleFibonacci(Scanner read) {
        System.out.println("--- SERIE DE FIBONACCI ---");
        int numFibo = Validations.requestPositiveInteger(read, "Ingrese la posicion de la serie que desea conocer: ");

        MetricsResults iterFibo = MathLogics.iterativeFibonacci(numFibo);
        printMetrics("--- FIBONACCI ITERATIVO ---", iterFibo);

        MetricsResults recFibo = MathLogics.recursiveFibonacci(numFibo);
        printMetrics("--- FIBONACCI RECURSIVO ---", recFibo);
    }

    private static void handleMCD(Scanner read) {
        System.out.println("--- CALCULAR MCD (ALGORITMO DE EUCLIDES) ---");
        int num1 = Validations.requestPositiveInteger(read, "Ingrese el primer numero entero positivo (M): ");
        int num2 = Validations.requestPositiveInteger(read, "Ingrese el segundo numero entero positivo (N): ");

        MetricsResults iterMCD = MathLogics.iterativeMCD(num1, num2);
        printMetrics("--- MCD ITERATIVO ---", iterMCD);

        MetricsResults recMCD = MathLogics.recursiveMCD(num1, num2);
        printMetrics("--- MCD RECURSIVO ---", recMCD);
    }

    private static void showCredits() {
        System.out.println("--- CREDITOS ---");
        System.out.println("Materia: Estructuras de Datos");
        System.out.println("Autor: Juan Diego Arroyo Bucio");
        System.out.println("ID (Matricula): [55420050]");
    }


    private static void printMetrics(String title, MetricsResults metrics) {
        System.out.println(title);
        System.out.println("Resultado: " + metrics.getResults());
        System.out.println("Contador de vueltas/llamadas: " + metrics.getCounter());
        System.out.println("Tiempo: " + String.format("%.6f", metrics.getTimeMs()) + " ms");
    }
    }


