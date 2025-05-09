package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        validarNombre(nombre);
        this.name = nombre;
    }

    public void alquilar(Alquiler rental) {

        alquileres.add(rental);
    }

    //metodo refactorizado

    public Object[] calcularDeudaYPuntosObtenidosRefactor() {
        Object[] resultado = new Object[this.alquileres.toArray().length];
        double total = 0;
        int puntosAlquilerFrecuente = 0;
        for (Alquiler alquiler : alquileres) {
            total += alquiler.calcularMonto();
            // sumo puntos por alquiler
            puntosAlquilerFrecuente++;
            // bonus por dos días de alquiler de un nuevo lanzamiento
            if ((alquiler.sumaPuntos()) && alquiler.diasAlquilados() > 1) {
                puntosAlquilerFrecuente++;
            }
        }
        resultado[0] = total;
        resultado[1] = puntosAlquilerFrecuente;
        return resultado;
    }
    private void validarNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
    }

    //    public Object[] calcularDeudaYPuntosObtenidos() {
//        Object[] resultado = new Object[2];
//        double total = 0;
//        int puntosAlquilerFrecuente = 0;
//        for (Alquiler alquiler : alquileres) {
//            double monto = 0;
//// determine amounts for each line
//            switch (alquiler.copia().libro().codigoPrecio()) {
//                case Libro.REGULARES:
//                    monto += 2;
//                    if (alquiler.diasAlquilados() > 2)
//                        monto += (alquiler.diasAlquilados() - 2) * 1.5;
//                    break;
//                case Libro.NUEVO_LANZAMIENTO:
//                    monto += alquiler.diasAlquilados() * 3;
//                    break;
//                case Libro.INFANTILES:
//                    monto += 1.5;
//                    if (alquiler.diasAlquilados() > 3)
//                        monto += (alquiler.diasAlquilados() - 3) * 1.5;
//                    break;
//            }
//            total += monto;
//            // sumo puntos por alquiler
//            puntosAlquilerFrecuente++;
//            // bonus por dos días de alquiler de un nuevo lanzamiento
//            if ((alquiler.copia().libro().codigoPrecio() == Libro.NUEVO_LANZAMIENTO)
//                    && alquiler.diasAlquilados() > 1) {
//                puntosAlquilerFrecuente++;
//            }
//        }
//        resultado[0] = total;
//        resultado[1] = puntosAlquilerFrecuente;
//        return resultado;
//    }

}

//metodo refactorizado