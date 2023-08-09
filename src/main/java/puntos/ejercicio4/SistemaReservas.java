package puntos.ejercicio4;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class SistemaReservas {

    static List<Hotel> hotels=new ArrayList<>();
   static List<Reserva> reservas = new ArrayList<>();
    public static void reservar() {

        llenarListaHoteles();

        String listaOpciones;
        String opcion="";

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Marcos", "123456789","Exito"));
        clientes.add(new Cliente("Jaime", "987654321","Softlond"));
 do {
        listaOpciones=clientes.stream().map(Objects::toString)
                        .collect(Collectors.toList()).toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");


      opcion=JOptionPane.showInputDialog("Ingrese la identificacion para logearse ó 0 para crear un cliente\n"+listaOpciones);

        if(opcion.equals(0)){
            String nom=JOptionPane.showInputDialog("Ingrese Identificacion");
            String ced=JOptionPane.showInputDialog("Ingrese Nombre Cliente");
            String nomEmpresa=JOptionPane.showInputDialog("Ingrese Nombre Empresa");
            clientes.add(new Cliente(nom,ced,nomEmpresa));
            continue;
        } else  {

            String finalOpcionC = opcion;
            Optional<Cliente> optionalCliente=clientes.stream()
                    .filter(p->p.getCedula().equals(finalOpcionC))
                    .findFirst();
            if(optionalCliente.isPresent()){
                Cliente cliente=optionalCliente.get();
                listaOpciones=hotels.stream().map(Object::toString)
                        .collect(Collectors.toList())
                        .toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "");

              opcion=JOptionPane.showInputDialog("Bienvenido "+cliente.getNombre() +"\n1. Ver Hoteles\n2. Ver Reservas");

              if(opcion.equals("1")){

                  opcion= JOptionPane.showInputDialog("Bienvenido "+cliente.getNombre() +"\nIngrese la opcion del Hotel del que desea listar" +
                          " sus habitaciones disponibles para reservar.\n"+listaOpciones);

                  listaOpciones=
                          hotels.get(Integer.parseInt(opcion)-1).getHabitacionesDisponibles()
                                  .stream()
                                  .map(Habitacion::getNumero)
                                  .map(Object::toString)
                                  .collect(Collectors.joining(","));

                  String validadorHabitacion;
                  do{
                      int numHabitacion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la habitacion a reservar\n" +
                              "Habitaciones Disponible: "+listaOpciones));
                      Habitacion habitacion=hotels.get(Integer.parseInt(opcion)-1).getHabitacionesDisponibles()
                              .stream()
                              .filter(habi->habi.getNumero()==numHabitacion)
                              .findFirst()
                              .orElse(null);
                      if(habitacion!=null){
                          reservas.add(new Reserva(habitacion,cliente));
                          break;
                      }
                      else {
                          validadorHabitacion= JOptionPane.showInputDialog("La habitacion no esta disponible\nIngrese terminar para cacelar o otro digito para intentar de nuevo.");
                      }
                  }while (!validadorHabitacion.equals("terminar"));

              } else if (opcion.equals("2")) {
                  listaOpciones=reservas.stream()
                          .filter(clien->clien.getCliente().equals(cliente))
                          .collect(Collectors.toList())
                          .toString()
                          .replace("[", "")
                          .replace("]", "")
                          .replace(",", "");

                  opcion=JOptionPane.showInputDialog("Ingrese un codigo de reserva si desea ver su informacion.\n" +
                          listaOpciones);

                  String finalOpcion = opcion;
                  Reserva reserva= reservas.stream().filter(cod -> cod.getNumReserva() == Integer.parseInt(finalOpcion))
                          .findFirst().orElse(null);
                  if(reserva!=null){
                      opcion=JOptionPane.showInputDialog("°Empresa:"+reserva.getCliente().getNombreEmpresa()+
                              "\n°Nombre del Hospedado: "+reserva.getCliente().getNombre()+
                              "\n°Cedula: "+reserva.getCliente().getCedula()+"\n\n" +
                              "Escriba cancelar para cancelar la reserva.");

                      if(opcion.equalsIgnoreCase("cancelar")){
                          reserva.cancelar();
                          reservas.remove(reserva);
                          JOptionPane.showMessageDialog(null,"Su reserva con codigo " +reserva.getNumReserva()+" a sido cancelada");

                      }
                  }     }         }
        }
 }while(!opcion.equalsIgnoreCase("terminar"));

    }


    public static void llenarListaHoteles(){

        hotels.add(new Hotel("Hotel Medellin", 10));
        hotels.add(new Hotel("Hotel Bogota", 15));
        hotels.add(new Hotel("Hotel Cartagena", 50));
        hotels.add(new Hotel("Hotel Santa Marta", 25));
        hotels.add(new Hotel("Hotel Cali", 30));
        hotels.add(new Hotel("Hotel Manizales", 20));
    }

}
