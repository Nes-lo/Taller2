package puntos.ejercicio1;

public class Alumno {

    private String nombre;
    private int edad;
    private double calificacion;

    public Alumno(String nombre, int edad, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad+", Calificacion: "+calificacion;
    }
}
