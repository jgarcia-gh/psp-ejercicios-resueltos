package pconcurrente.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Log l = new Log();
        List<Thread> threads = new ArrayList<Thread>();

        // Lanzamos 5 hilos, todos ellos compartiendo la misma instancia de la clase Log
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(new Escritor(i, l));
            t.start();
            threads.add(t);
        }

        // Esperamos al finalización de los 5 hilos
        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hilos finalizados");
        l.cerrar();
    }
}
