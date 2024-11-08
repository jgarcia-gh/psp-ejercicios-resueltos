package pconcurrente.ejercicio1a;

import java.util.Random;

public class Contador implements Runnable{

    private int n1;
    private int n2;

    public Contador(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    @Override
    public void run() {
        for(int i = n1; i <= n2; i++){
            System.out.println(i);
            Random r = new Random();
            int espera = r.nextInt(1000);
            try{
                Thread.sleep(espera);
            } catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        }
    }
}
