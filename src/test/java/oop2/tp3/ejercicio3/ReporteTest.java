package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteTest {
    @Test
    public void testReporte() { //TODO pensar otro nombre
        var g1 = new Desayuno(1500);
        var reporte = new ReporteDeGastos(List.of(g1));
        assertEquals("Expenses " + LocalDate.now() + "\n" +
                "Desayuno 1500    X\n" +
                "Total de gastos: 1500", reporte.imprimir());
    }
}
