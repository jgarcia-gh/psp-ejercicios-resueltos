package pconcurrente.ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Thread> hilos = new ArrayList<Thread>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de hilos a crear: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            Thread t = new Thread(new CalculaPrimos());
            t.setName("Hilo " + i);
            hilos.add(t);
            t.start();
        }

        boolean hayHilosEnEjecucion = true;
        while(hayHilosEnEjecucion){
            hayHilosEnEjecucion = false;
            for(Thread t : hilos){
                System.out.println(t.getId() + " " + t.getName() + " " + t.getState());
                hayHilosEnEjecucion = hayHilosEnEjecucion || t.isAlive();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
