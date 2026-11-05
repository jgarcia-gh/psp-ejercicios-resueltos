package pconcurrente.ejercicio8;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
                contenedor.crearCaja();
                System.out.println("Hilo Consumidor: Caja creada");
            }
        }

}
