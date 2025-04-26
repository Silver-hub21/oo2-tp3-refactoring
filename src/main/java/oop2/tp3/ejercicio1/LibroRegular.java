package oop2.tp3.ejercicio1;

public class LibroRegular extends Libro{
    public static final int REGULAR = 0;

    public LibroRegular(String nombre) {
        super(nombre);
    }

    @Override
    public int codigoPrecio() {
        return REGULAR;
    }

    @Override
    public double montoPorAlquiler(Alquiler alquiler) {
        double monto = 2;
        if (alquiler.diasAlquilados() > 2){
            monto += (alquiler.diasAlquilados() - 2) * 1.5;
        }
        return monto;
    }

    @Override
    public boolean sumarPuntos() {
        return false;
    }

}
