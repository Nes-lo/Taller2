import puntos.ejercicio1.SistemaAlumnos;
import puntos.ejercicio2.ListaConversores;
import puntos.ejercicio3.Operaciones;
import puntos.ejercicio4.SistemaReservas;

import javax.swing.*;

public class Taller2_Softlondo {


    public static void main(String[] args) {

        String listaOpciones="";
        int opcion;
        listaOpciones="1. Sistema de Alumnos \n"
                +"2. Conversor de Monedas \n"
                +"3. Calculadora Simple \n"
                +"4. Sistema de Reservas de Hotel";

        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog(listaOpciones));

            switch (opcion){
                case 1:
                    SistemaAlumnos.gestionarAlumnos();
                    break;
                case 2:
                    ListaConversores.conversores();
                    break;
                case 3:
                    Operaciones.operando();
                    break;
                case 4:
                    SistemaReservas.reservar();
                    break;
                default:

                    break;
            }
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese 0 para terminar o 1 para continuar"));

        }while (opcion!=0);




    }
}
