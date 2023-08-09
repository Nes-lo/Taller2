package puntos.ejercicio4;

public class Cliente {
    private String nombre;
    private String cedula;
    private String nombreEmpresa;

    public Cliente(String nombre, String cedula,String nombreEmpresa) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nombreEmpresa=nombreEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    @Override
    public String toString(){
        return "Identificacion: "+ cedula+" Nombre: "+nombre+" Empresa: "+nombreEmpresa+"\n";
    }

}
