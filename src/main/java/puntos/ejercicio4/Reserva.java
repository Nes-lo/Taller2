package puntos.ejercicio4;

import java.util.List;

public class Reserva {
    private Hotel hotel;
    private List<Habitacion> habitaciones;
    private Cliente cliente;
    private static int reservaCodigo=1000;
    private int numReserva;
    private Habitacion habitacion;

    public Reserva(Habitacion habitacion, Cliente cliente) {
        this.cliente = cliente;
        this.habitacion=habitacion;
        this.habitacion.ocupar(cliente);
        this.hotel=habitacion.getHotel();
        this.numReserva=++reservaCodigo;

    }

    public void cancelar() {
      habitacion.liberar();
    }

    public int getNumReserva() {
        return numReserva;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Habitacion getHabitaciones() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString(){
        return "Numero Reserva "+ numReserva +" en la habitacion "+habitacion.getNumero()+" en el hotel "+hotel.getNombre()+"\n";
    }


}
