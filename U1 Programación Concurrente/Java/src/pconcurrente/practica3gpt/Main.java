package pconcurrente.practica3gpt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);  // Pool para los 4 carriles
        Carril[] carriles = new Carril[4];

        for (int i = 0; i < 4; i++) {
            Carril carril = new Carril(i + 1);
            carriles[i] = carril;

            // Crear hilos para los corredores del carril
            int carrilId = i + 1;
            executorService.submit(() -> {
                ExecutorService corredorExecutor = Executors.newFixedThreadPool(4);
                Corredor[] corredores = new Corredor[4];
                corredores[0] = new Corredor(1, carril, true);   // Primer corredor con testigo
                corredores[1] = new Corredor(2, carril, false);
                corredores[2] = new Corredor(3, carril, false);
                corredores[3] = new Corredor(4, carril, false);

                // Añadir corredores al carril en las posiciones correctas
                carril.añadirCorredor(corredores[0], 0);
                carril.añadirCorredor(corredores[1], 100000);
                carril.añadirCorredor(corredores[2], 200000);
                carril.añadirCorredor(corredores[3], 300000);

                // Lanzar hilos de los corredores
                for (Corredor corredor : corredores) {
                    corredorExecutor.submit(corredor);
                }

                // Esperar a que terminen todos los corredores del carril
                corredorExecutor.shutdown();
                try {
                    corredorExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Carril " + carrilId + " ha terminado la carrera.");
            });
        }

        executorService.shutdown();

        // Esperar a que terminen todos los carriles
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas las carreras han terminado.");
    }
}