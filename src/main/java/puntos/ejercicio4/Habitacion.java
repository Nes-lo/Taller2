package puntos.ejercicio4;

public class Habitacion {
    private int numero;
    private boolean disponible = true;
    private Cliente ocupante;
    private Hotel hotel;
    public Habitacion(int numero, Hotel hotel) {
        this.numero = numero;
        this.hotel=hotel;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar(Cliente cliente) {
        disponible = false;
        ocupante = cliente;
    }

    public void liberar() {
        disponible = true;
        ocupante = null;
    }

    public Cliente getOcupante() {
        return ocupante;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
