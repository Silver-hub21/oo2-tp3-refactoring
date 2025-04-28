package oop2.tp3.ejercicio1;

public class Alquiler {
    private CopiaLibro copia;
    private int diasAlquilados;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        validarCopia(copia);
        validarDiasAlquilados(diasAlquilados);
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
    }

    public int diasAlquilados() {

        return this.diasAlquilados;
    }

    public CopiaLibro copia() {

        return this.copia;
    }

    public int obtenerCodigoPrecio() {
        return this.copia.obtenerCodigoPrecioLibro();
    }

    public boolean sumaPuntos() {
        return this.copia.libro().sumarPuntos();
    }

    public double calcularMonto() {
        return this.copia.obtenerMonto(this);
    }

    private void validarDiasAlquilados(int diasAlquilados) {
        if(diasAlquilados <= 0){
            throw new RuntimeException("Dias alquilados invalidos.");
        }
    }

    private void validarCopia(CopiaLibro copia) {
        if(copia == null){
            throw new RuntimeException("Debe agregar la copia del libro, no puede ser nula.");
        }
    }

}
