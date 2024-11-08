package pconcurrente.ejercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num = (int)(Math.random() * 10) + 10;

        Contador c = new Contador();
        Thread t = new Thread(c);
        t.start();

        System.out.println("Pulsa enter cuando creas que el contador ha llegado a " + num);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        c.detener();

        // Esperamos a que finalice el hilo
        while(t.isAlive()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(c.getCuenta() == num){
            System.out.println("Lo has conseguido!");
        } else {
            System.out.printf("Vuelve a intentarlo, has detenido el contador en " + c.getCuenta());
        }
    }

}
