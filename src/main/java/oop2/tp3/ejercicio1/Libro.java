package oop2.tp3.ejercicio1;

public abstract class Libro {
    private String nombre;

    public Libro(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public abstract int codigoPrecio();

    public abstract double montoPorAlquiler(Alquiler alquiler);

    public abstract boolean sumarPuntos();

    public String nombre() {

        return nombre;
    }

    private void validarNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
    }
}