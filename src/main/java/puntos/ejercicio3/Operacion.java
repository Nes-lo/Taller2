package puntos.ejercicio3;

public class Operacion {

    private Double numUno;

    private  Double resultadoOperacion;

    public Operacion(){
        this.resultadoOperacion=0.0;
        this.numUno=null;
    }

    public void sumar(){
        if(numUno!=null){
            resultadoOperacion+=numUno;
            numUno=null;
        }

    }

    public void restar(){
        if(numUno!=null){
            resultadoOperacion-=numUno;
            numUno=null;
        }

    }

    public void multiplicar(){
        if(numUno!=null){
            resultadoOperacion*=numUno;
            numUno=null;
        }

    }

    public void  dividir()
    {
        if(numUno!=null){
            resultadoOperacion/=numUno;
            numUno=null;
        }

    }

    public Double getNumUno() {
        return numUno;
    }

    public void setNumUno(Double numUno) {
        this.numUno = numUno;
    }

    public Double getResultadoOperacion(){
        return resultadoOperacion;
    }

    public void setResultadoOperacion(Double resultadoOperacion){
        this.resultadoOperacion=resultadoOperacion;
    }
    public void setReset(){
        this.resultadoOperacion=0.0;
    }

}
