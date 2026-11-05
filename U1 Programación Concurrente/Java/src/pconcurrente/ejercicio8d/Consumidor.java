package pconcurrente.ejercicio8d;

import java.util.ArrayList;
import java.util.Random;
public class Consumidor implements Runnable{

    private Contenedor contenedor;
    public Consumidor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    @Override
    public void run() {
        while(true){



                ArrayList<Capsula> capsulasExtraidas = contenedor.extraerCapsulas();

                System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");

                // Simulamos que empaquetamos las cápsulas
                Random r = new Random();
                try {
                    Thread.sleep(r.nextInt(1000,3000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Hilo Consumidor: Caja creada");
            }
        }

}
