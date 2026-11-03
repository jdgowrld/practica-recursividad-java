package logics;

import dtos.MetricsResults;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 * */

public class MathLogics {
    // 1. FACTORIAL ITERATIVO
    public static MetricsResults iterativeFactorial(int n) {
        long starTime = System.nanoTime();
        long  counter = 0;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
            counter++;
        }
        double timeMs = (System.nanoTime() - starTime) / 1000000.0;
        return new MetricsResults(result, counter, timeMs);
    }

    // 2. FACTORIAL RECURSIVO (envoltorio)
    public static MetricsResults recursiveFactorial(int n) {
        long startTime = System.nanoTime();

        long[] counter = {0};

        long result = doRecursiveFactorial(n, counter);

        double timeMs = (System.nanoTime() - startTime) / 1000000.0;

        return new MetricsResults(result, counter[0], timeMs);
    }

    // 3. FACTORIAL RECURSIVO
    private static long doRecursiveFactorial(int n, long[] counter) {
        counter[0]++;

        if (n == 0 || n == 1) {
            return 1;
        }
        // CASO RECURSIVO: La función se llama a sí misma
        return n * doRecursiveFactorial(n - 1, counter);
    }

    // 4. FIBONACCI ITERATIVO
    public static MetricsResults iterativeFibonacci(int n) {
        long startTime = System.nanoTime();
        long counter = 0;
        long result = 0;


        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {

            long prev1 = 0;
            long prev2 = 1;

            for (int i = 2; i <= n; i++) {
                result = prev1 + prev2;
                prev1 = prev2;
                prev2 = result;
                counter++;
            }
        }

        double timeMs = (System.nanoTime() - startTime) / 1000000.0;
        return new MetricsResults(result, counter, timeMs);
    }


    // 5. FIBONACCI RECURSIVO (El Wrapper)
    public static MetricsResults recursiveFibonacci(int n) {
        long startTime = System.nanoTime();


        long[] counter = {0};

        long result = doRecursiveFibonacci(n, counter);

        double timeMs = (System.nanoTime() - startTime) / 1000000.0;
        return new MetricsResults(result, counter[0], timeMs);
    }


    // 6. FIBONACCI RECURSIVO (Worker Privado)
    private static long doRecursiveFibonacci(int n, long[] counter) {
        counter[0]++;

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return doRecursiveFibonacci(n - 1, counter) + doRecursiveFibonacci(n - 2, counter);
    }


    // 7. MCD ITERATIVO (Algoritmo de Euclides)
    public static MetricsResults iterativeMCD(int m, int n) {
        long startTime = System.nanoTime();
        long counter = 0;

        if (n == 0) return new MetricsResults(m, 0, 0.0);

        int res = m % n;

        while (res != 0) {
            m = n;
            n = res;
            res = m % n;
            counter++;
        }

        double timeMs = (System.nanoTime() - startTime) / 1000000.0;
        return new MetricsResults(n, counter, timeMs);
    }


    // 8. MCD RECURSIVO (El Wrapper)
    public static MetricsResults recursiveMCD(int m, int n) {
        long startTime = System.nanoTime();
        long[] counter = {0};

        if (n == 0) return new MetricsResults(m, 0, 0.0);

        long result = doRecursiveMCD(m, n, counter);

        double timeMs = (System.nanoTime() - startTime) / 1000000.0;
        return new MetricsResults(result, counter[0], timeMs);
    }


    // 9. MCD RECURSIVO (El Worker Privado)
    private static long doRecursiveMCD(int m, int n, long[] counter) {
        counter[0]++;


        if (m % n == 0) {
            return n;
        }

        return doRecursiveMCD(n, m % n, counter);
    }

}