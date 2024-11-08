package pconcurrente.ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de hilos a crear: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            Thread t = new Thread(new CalculaPrimos());
            t.setName("Hilo " + i);
            t.start();
        }

    }
}
