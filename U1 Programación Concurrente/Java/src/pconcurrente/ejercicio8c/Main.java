package pconcurrente.ejercicio8c;

public class Main {

    private static final int NUMERO_PRODUCTORES= 4;

    public static void main(String[] args) {

        Contenedor contenedor = new Contenedor();

        for(int i = 0; i < NUMERO_PRODUCTORES; i++) {
            Productor p = new Productor(4, Variedad.COLOMBIA, contenedor);
            Thread tp = new Thread(p);
            tp.start();
        }

        Consumidor c = new Consumidor(contenedor);
        Thread tc = new Thread(c);
        tc.start();
    }
}
