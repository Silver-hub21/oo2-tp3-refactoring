package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    private List<Gasto> gastos;

    public ReporteDeGastos(List<Gasto> gastos){
        this.gastos = gastos;
    }

    public String imprimir() {
        int total = 0;

        StringBuilder reporte = new StringBuilder("Expenses " + LocalDate.now() + "\n");

        for (Gasto gasto : this.gastos) {
            int gastosDeComida = gasto.calcularGasto();
            reporte.append(gasto.etiquetar()); //agrega el tipo del gasto
            reporte.append(" ").append(gastosDeComida); //agrega el monto del gasto
            gasto.marcaExceso(reporte); //marca si se excede el gasto
            reporte.append("\n"); //agrega un salto de línea si o si
            total += gasto.monto;
        }
        return String.valueOf(reporte.append("Total de gastos: ").append(total));
    }

}
