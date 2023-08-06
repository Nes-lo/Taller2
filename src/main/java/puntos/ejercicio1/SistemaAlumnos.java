package puntos.ejercicio1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaAlumnos {
    public static void gestionarAlumnos(){
        char continuar='c';
        List<Alumno>  alumnos=new ArrayList<>();
       do {
           if (continuar=='c'){
               String alumnoName= JOptionPane.showInputDialog("Ingrese Nombre del Alumno");
               int alumnoEdad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese Edad del Alumno"));
               double alumnoCalificacion=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Calificacion del Alumno entre 0 y 5"));
               alumnos.add(new Alumno(alumnoName,alumnoEdad,alumnoCalificacion));
           }
           continuar=JOptionPane.showInputDialog("Ingrese 'c' para ingresar otro alumno o 't' para terminar").charAt(0);


       }while(continuar!='t');


        System.out.println("La lista de alumnos es: ");
        alumnos.stream().forEach(System.out::println);


        System.out.println("El promedio de las notas del los alumnos es: "+alumnos.stream().mapToDouble(p->p.getCalificacion()).average());



    }
}
