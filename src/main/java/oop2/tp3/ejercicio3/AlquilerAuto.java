package oop2.tp3.ejercicio3;

public class AlquilerAuto extends Gasto{
    public AlquilerAuto(int monto) {
        super(monto);
    }

    @Override
    public String etiquetar() {
        return "Alquiler de Autos";
    }

    @Override
    public void marcaExceso(StringBuilder reporte) {
        if(monto > 1000){
            reporte.append("    X");
        } else{
            reporte.append("");
        }
    }

    @Override
    public int calcularGasto() {
        return 0;
    }


}
