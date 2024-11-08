package pconcurrente.ejercicio8;

import java.util.Random;

public class Productor implements Runnable {

    private boolean ejecutar = true;
    private String variedad;
    private int intensidad;
    private Contenedor contenedor;

    public Productor (Contenedor contenedor, String variedad, int intensidad){
        this.variedad = variedad;
        this.intensidad = intensidad;
        this.contenedor = contenedor;
    }
    public void Detener(){
        ejecutar = false;
    }
    @Override
    public void run() {
        Random r = new Random();
        while(ejecutar){
            try {

                Thread.sleep(r.nextInt(502) + 499); // Espera entre 500 y 1000 ms
                synchronized (contenedor){
                    Capsula c = new Capsula(variedad, intensidad);
                    contenedor.anyadirCapsula(c);
                    System.out.println("Hilo Productor: Se ha fabricado una cápsula. Total en contenedor: " + contenedor.numeroCapsulas());
                    if(contenedor.numeroCapsulas() >= 6){
                        contenedor.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
