package oop2.tp3.ejercicio1;

public abstract class Libro {
    private String nombre;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public abstract int codigoPrecio();

    public abstract double montoPorAlquiler(Alquiler alquiler);

    public abstract boolean sumarPuntos();

    public String nombre() {

        return nombre;
    }
}