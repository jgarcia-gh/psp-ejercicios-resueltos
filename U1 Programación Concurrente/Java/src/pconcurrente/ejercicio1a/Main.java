package pconcurrente.ejercicio1a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce n1: ");
        int n1 = sc.nextInt();
        System.out.print("Introduce n2: ");
        int n2 = sc.nextInt();

        Thread t = new Thread(new Contador(n1, n2));
        t.start();
        System.out.println("El hilo se ha lanzado");

    }
}
