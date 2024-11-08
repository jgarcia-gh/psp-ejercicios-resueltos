package pconcurrente.ejercicio5;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Indica cada cuántos segundos quieres que se guarde el saludo: ");
        int segundos = sc.nextInt();
        sc.nextLine();

        Thread t = new Thread(() -> {
            try {
                PrintWriter pw = new PrintWriter(new File("./Files/ejercicio5"));
                try {
                    while(!Thread.currentThread().isInterrupted()){
                        pw.println("¡Hola mundo!");
                        Thread.sleep(segundos*1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }

                pw.close();
                System.out.println("¡Adiós!");
            } catch (IOException e) {
                System.out.println("Fichero no existe");
            }
        });

        t.start();

        System.out.print("Pulsa enter para interrumpir el hilo: ");
        sc.nextLine();
        System.out.println("Interrumpiendo hilo");
        t.interrupt();

    }
}
