package dtos;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Estructura de Datos.
 */
public class MetricsResults {
    private long results;
    private long counter;
    private double timeMs;



   //Getters
    public long getResults() {
        return results;
    }

    public long getCounter() {
        return counter;
    }

    public double getTimeMs() {
        return timeMs;
    }

    //Constructor
    public MetricsResults(long results, long counter, double timeMs) {
        this.results = results;
        this.counter = counter;
        this.timeMs = timeMs;
    }

}