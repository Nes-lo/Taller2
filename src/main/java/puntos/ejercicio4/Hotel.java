package puntos.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hotel {
    private String nombre;
    private static int numeroHotel=0;
    private List<Habitacion> habitaciones;
    private int identificador;

    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        this.identificador=++numeroHotel;
        habitaciones = new ArrayList<>();
        habitaciones = IntStream.rangeClosed(1, numHabitaciones)
                .mapToObj(numero -> new Habitacion(numero, this))
                .collect(Collectors.toList());
    }

    public String getNombre() {
        return nombre;
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> disponibles = habitaciones.stream()
                .filter(Habitacion::isDisponible)
                .collect(Collectors.toList());

        return disponibles;
    }

    public int getIdentificador() {
        return identificador;
    }

    public List<Habitacion> getHabitacionesOcupadas(){
        List<Habitacion> ocupadas = new ArrayList<>();
        habitaciones.stream()
                .filter(habitacion -> !habitacion.isDisponible())
                .collect(Collectors.toList());
        return ocupadas;
    }

    @Override
    public String toString(){
        return this.identificador+" "+this.nombre+"\n";
    }

}
