package puntos.ejercicio2;


import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.*;

public class ListaConversores {

   private static List<ConversorMoneda> conversorMonedas;

   private  static void rellenar(){
       crearConversor("Dollares a Pesos",4140,"Dollares","Pesos");
       crearConversor("Pesos a Dollares",0.000241,"Pesos","Dollares");
       crearConversor("Euros a Pesos",4565,"Euros","Pesos");
       crearConversor("Pesos a Euros",0.0000219,"Pesos","Euros");
       crearConversor("Dollares a Euros",0.9090,"Dollares","Euros");
       crearConversor("Euros a Dollares",1.1,"Euros","Dollares");

   }
    public static void conversores(){
          conversorMonedas=new ArrayList<>();
         int opcion=0;
         rellenar();
        do{

            String showDialogo= String.format("Ingrese 0 para crear un conversor de Monedas \n ó Ingrese un numero de la lista para usar: \n%s",
                    conversorMonedas.stream().map(p->p.toString())
                    .collect(joining("\n")));
            opcion=Integer.parseInt(JOptionPane.showInputDialog(showDialogo));

            if(opcion>0 && opcion<= conversorMonedas.size()){
                opcion--;
                double valorEnMoneda=Double.parseDouble(
                        JOptionPane.showInputDialog("Ingrese la cantidad de dinero en  "+
                                conversorMonedas.get(opcion).getNombreMoneda1()));

                opcion=Integer.parseInt(JOptionPane.showInputDialog("Al cambio actual "+ valorEnMoneda+
                        " "+conversorMonedas.get(opcion).getNombreMoneda1()+" son "+
                       conversorMonedas.get(opcion).getMonedaOut(valorEnMoneda)+" "+conversorMonedas.get(opcion).getNombreMoneda2()+"\n " +
                        "\n Ingrese -1 para terminar o 1 para una nueva operacion."));


            }else {
                if(opcion==0){
                    crearConversor();
                    opcion=1;
                }
            }

        }while (opcion!=-1);

    }

    public static void crearConversor(){

        String nombreConversor=JOptionPane.showInputDialog("Ingrese Nombre Conversor.");
        String nombreMoneda1=JOptionPane.showInputDialog("Ingrese nombre de moneda que va a convertir.");
        String nombreMoneda2=JOptionPane.showInputDialog("Ingrese nombre de moneda a la que se va a convertir.");
        double tasaCambio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tasa de cambio."));
        conversorMonedas.add(new ConversorMoneda(nombreConversor,tasaCambio,nombreMoneda1,nombreMoneda2));
    }
    public static void crearConversor(String nombreConversor, double tasaCambio, String nombreMoneda1,String nombreMoneda2 ){
        conversorMonedas.add(new ConversorMoneda(nombreConversor,tasaCambio,nombreMoneda1,nombreMoneda2));
    }


}
