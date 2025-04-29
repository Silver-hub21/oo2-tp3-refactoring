package oop2.tp3.ejercicio3;

public class Cena extends Gasto{
    public Cena(int monto) {
        super(monto);
    }

    @Override
    public String etiquetar() {
        return "Cena";
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
