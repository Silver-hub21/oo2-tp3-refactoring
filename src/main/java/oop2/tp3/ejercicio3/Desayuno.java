package oop2.tp3.ejercicio3;

public class Desayuno extends Gasto{
    public Desayuno(int monto) {
        super(monto);
    }

    @Override
    public String etiquetar() {
        return "Desayuno";
    }

    @Override
    public void marcaExceso(StringBuilder reporte)  {
        if(monto > 1000){
            reporte.append("    X");
        } else{
          reporte.append("");
        }
    }

    @Override
    public int calcularGasto() {
        return this.monto;
    }


}
