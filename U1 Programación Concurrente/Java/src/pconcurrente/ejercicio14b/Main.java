package pconcurrente.ejercicio14b;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ReentrantLock rl = new ReentrantLock();
        Interseccion i1 = new Interseccion("Int. 1", rl);
        Interseccion i2 = new Interseccion("Int. 2", rl);
        List<Posicion> camino1 = List.of(
                new Recta("Rect. 1"),
                i1,
                i2,
                new Recta("Rect. 2")
        );
        List<Posicion> camino2 = List.of(
                new Recta("Rect. 3"),
                i2,
                i1,
                new Recta("Rect. 4")
        );
        new Thread(new Robot("R1", camino1)).start();
        new Thread(new Robot("R2", camino2)).start();

    }
}
