package pconcurrente.ejercicio1c;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce n1: ");
        int n1 = sc.nextInt();
        System.out.print("Introduce n2: ");
        int n2 = sc.nextInt();

        Thread t = new Thread(() ->{
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
            });

        t.start();
        System.out.println("El hilo se ha lanzado");

    }
}
