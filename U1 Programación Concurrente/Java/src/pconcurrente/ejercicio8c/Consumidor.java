package pconcurrente.ejercicio8c;

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

                while(contenedor.size()<6){
                    try {
                        synchronized (contenedor) {
                            contenedor.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");

                ArrayList<Capsula> capsulasExtraidas = contenedor.extraerCapsulas();

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
