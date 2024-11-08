package pconcurrente.practica3;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Object lock = new Object();
    public static ArrayList<Carril> carrilesTerminados = new ArrayList<Carril>();

    public static final int NUM_CARRILES = 4;

    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < NUM_CARRILES; i++){
            final int id = i;
            Thread t = new Thread(()->{
                Carril p = new Carril(id);
                Corredor c1 = new Corredor(1,p,true);
                Corredor c2 = new Corredor(2,p,false);
                Corredor c3 = new Corredor(3,p,false);
                Corredor c4 = new Corredor(4,p,false);

                p.añadirCorredor(c1, 0);
                p.añadirCorredor(c2, 100000);
                p.añadirCorredor(c3, 200000);
                p.añadirCorredor(c4, 300000);

                ExecutorService es = Executors.newFixedThreadPool(4);
                es.execute(c1);
                es.execute(c2);
                es.execute(c3);
                es.execute(c4);

                es.shutdown();
                try {
                    es.awaitTermination(100, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Carril " + id + " ha finalizado la carrera. Notificamos a hilo principal.");
                synchronized (lock){
                    carrilesTerminados.add(p);
                    lock.notify();
                }
            });
            t.start();
        }

        int posicion = 1;
        while(carrilesTerminados.size() < NUM_CARRILES){

            synchronized (lock){
                lock.wait();
            }
            Carril p = carrilesTerminados.get(carrilesTerminados.size()-1);
            System.out.println("PODIUM: Posicion " + posicion + "º para el equipo de carril " + p.getId());
            posicion++;
        }


    }
}
