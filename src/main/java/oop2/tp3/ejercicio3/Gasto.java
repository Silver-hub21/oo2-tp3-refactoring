package oop2.tp3.ejercicio3;

public abstract class Gasto {
    int monto;

    public Gasto(int monto) {
        validarMonto(monto);
        this.monto = monto;
    }

    public abstract String etiquetar();

    private void validarMonto(int monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
    }

    public abstract void marcaExceso(StringBuilder reporte);

    public abstract int calcularGasto();
}
