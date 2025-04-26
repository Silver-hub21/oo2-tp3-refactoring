package oop2.tp3.ejercicio1;

public class LibroNuevoLanzamiento extends Libro{
    public static final int NUEVO_LANZAMIENTO = 1;

    public LibroNuevoLanzamiento(String nombre) {
        super(nombre);
    }

    @Override
    public int codigoPrecio() {
        return NUEVO_LANZAMIENTO;
    }

    @Override
    public double montoPorAlquiler(Alquiler alquiler) {
       return alquiler.diasAlquilados() * 3;
    }

    @Override
    public boolean sumarPuntos() {
        return true;
    }

}
