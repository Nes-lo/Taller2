package puntos.ejercicio2;

public class ConversorMoneda {

    private static int contadorConversores=0;
    private double tasaCambio;
    private double valorMonedaIn;
    private int numeroConversor;
    private String nombreConversor;
    private String nombreMoneda1, nombreMoneda2;

    public ConversorMoneda(String nombreConversor ,double tasaCambio,String nombreMoneda1, String nombreMoneda2){
        this.nombreConversor=nombreConversor;
        this.nombreMoneda1=nombreMoneda1;
        this.nombreMoneda2=nombreMoneda2;
        this.tasaCambio=tasaCambio;
        numeroConversor=++contadorConversores;
    }

    public double getMonedaOut(double valorMonedaIn){
        return tasaCambio*valorMonedaIn;
    }


    @Override
    public String toString() {

        return numeroConversor+". "+nombreConversor+" Tasa de Cambio "+tasaCambio;

    }

    public double getValorMonedaIn() {
        return valorMonedaIn;
    }

    public void setValorMonedaIn(double valorMonedaIn) {
        this.valorMonedaIn = valorMonedaIn;
    }

    public static int getContadorConversores() {
        return contadorConversores;
    }

    public String getNombreMoneda1() {
        return nombreMoneda1;
    }

    public String getNombreMoneda2() {
        return nombreMoneda2;
    }
}
