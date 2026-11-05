package pconcurrente.ejercicio14;

public abstract class Posicion {
    private Tipo tipo;
    protected String nombre;

    public Posicion(Tipo tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public abstract boolean entrar(Robot r);

    public abstract void salir(Robot r);
}
