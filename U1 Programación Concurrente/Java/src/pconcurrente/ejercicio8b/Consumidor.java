package pconcurrente.ejercicio8b;

import java.util.Random;

public class Consumidor implements Runnable{

    private boolean ejecutar = true;
    private Contenedor contenedor;

    public Consumidor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    public void Detener(){
        ejecutar = false;
    }
    @Override
    public void run() {
        Random r = new Random();
            while(ejecutar){
                synchronized (contenedor) {
                    while (contenedor.numeroCapsulas() < 6) {
                        try {
                            contenedor.wait(); // Esperamos hasta que nos notifiquen que hay al menos 6 cápsulas
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    contenedor.sacarCapsulas();
                }
                System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");
                try {
                    Thread.sleep(r.nextInt(2002) + 999); // Espera entre 1000ms y 3000 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hilo Consumidor: Caja creada");
            }
    }
}
