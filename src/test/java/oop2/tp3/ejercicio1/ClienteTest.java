package oop2.tp3.ejercicio1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    @Test
    void testCalcularDeudaYPuntosObtenidos() {

        Libro elTunel = new LibroRegular("El Túnel");
        Libro antesDelFin = new LibroRegular("Antes del Fin");
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        Cliente yo = new Cliente("Tomas");
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);

        Object[] resultado = yo.calcularDeudaYPuntosObtenidosRefactor();

        assertEquals(10.0, resultado[0]);
        assertEquals(2, resultado[1]);
    }
}
