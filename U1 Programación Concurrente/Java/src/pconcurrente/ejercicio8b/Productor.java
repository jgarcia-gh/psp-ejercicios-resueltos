package pconcurrente.ejercicio8b;

import java.util.Random;

public class Productor implements Runnable{

    private int intensidad;
    private Contenedor contenedor;
    private Variedad variedad;
    public Productor (int intensidad, Variedad variedad, Contenedor contenedor){
        this.intensidad = intensidad;
        this.variedad = variedad;
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true){
            try {
                Thread.sleep(r.nextInt(500,1001));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Capsula c = new Capsula(intensidad, variedad);
            contenedor.add(c);
            System.out.println("Hilo Productor: Se ha fabricado una cápsula. Total en contenedor: " + contenedor.size());
            if(contenedor.size()>=6){
                synchronized (contenedor) {
                    contenedor.notify();
                }
            }
        }
    }
}
