package oop2.tp3.ejercicio1;

public class LibroInfantil extends Libro{
    public static final int INFANTIL = 2;

    public LibroInfantil(String nombre) {
        super(nombre);
    }

    @Override
    public int codigoPrecio() {
        return INFANTIL;
    }

    @Override
    public double montoPorAlquiler(Alquiler alquiler) {
        double monto = 1.5;
        if (alquiler.diasAlquilados() > 3){
            monto += (alquiler.diasAlquilados() - 3) * 1.5;
        }
        return monto;
    }

    @Override
    public boolean sumarPuntos() {
        return false;
    }


}
