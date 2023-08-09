package puntos.ejercicio3;


import javax.swing.*;

public class Operaciones {
    public static void operando() {
        String tipoOperacion="";
        Operacion operacion = new Operacion();
         String opcion="";
        do {
           opcion= JOptionPane.showInputDialog("Ingrese un Numero o un operador como '+','-','*','/' o resetear para volver a 0 y terminar para finalizar el programa\n" +
                   "Operacion a realizar: "+tipoOperacion+
                   "\nNumero en memoria: "+operacion.getNumUno()+"\n"+"Resultado: "+operacion.getResultadoOperacion());

           if(opcion.equals("+") || opcion.equals("-") || opcion.equals("*") || opcion.equals("/")){
               switch (opcion){
                   case "+":
                       tipoOperacion="suma";
                       break;
                   case "-":
                       tipoOperacion="resta";
                       break;
                   case "*":
                       tipoOperacion="multiplicacion";
                                           break;
                   case "/":
                       tipoOperacion="division";
                                          break;
                   default:
               }
           }
           else if(!opcion.equalsIgnoreCase("terminar")){
               if(opcion.equalsIgnoreCase("resetear")){
                   operacion.setReset();
               }
               else if (opcion.matches("-?\\d+(\\.\\d+)?")){
                   if(operacion.getResultadoOperacion()==0.0){
                       operacion.setResultadoOperacion(Double.parseDouble(opcion));
                   }
                   else {
                       operacion.setNumUno(Double.parseDouble(opcion));
                       operar(tipoOperacion,operacion);
                   }

               }
           }




        }while (!opcion.equalsIgnoreCase("terminar"));

    }

    private static void operar(String tipoOperacion, Operacion operacion){

        if(tipoOperacion.equalsIgnoreCase("suma")){
           operacion.sumar();
        }
        else if(tipoOperacion.equalsIgnoreCase("resta")){
            operacion.restar();
        }
        else if(tipoOperacion.equalsIgnoreCase("multiplicacion")){
           operacion.multiplicar();
        }
        else if(tipoOperacion.equalsIgnoreCase("division")){
               operacion.dividir();
        }


    }

}
