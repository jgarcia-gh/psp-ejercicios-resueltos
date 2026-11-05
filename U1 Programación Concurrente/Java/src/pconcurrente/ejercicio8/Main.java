package pconcurrente.ejercicio8;

import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Contenedor contenedor = new Contenedor();

        Productor p = new Productor(4, Variedad.COLOMBIA, contenedor);
        Thread tp = new Thread(p);
        tp.start();

        Consumidor c = new Consumidor(contenedor);
        Thread tc = new Thread(c);
        tc.start();
    }
}
