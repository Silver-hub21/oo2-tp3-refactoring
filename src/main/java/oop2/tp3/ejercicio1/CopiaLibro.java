package oop2.tp3.ejercicio1;

public class CopiaLibro {
    private Libro libro;

    public CopiaLibro(Libro libro) {

        this.libro = libro;
    }

    public Libro libro() {

        return libro;
    }

    public int obtenerCodigoPrecioLibro() {
        return libro.codigoPrecio();
    }

    public double obtenerMonto(Alquiler alquiler) {
        return libro().montoPorAlquiler(alquiler);
    }
}