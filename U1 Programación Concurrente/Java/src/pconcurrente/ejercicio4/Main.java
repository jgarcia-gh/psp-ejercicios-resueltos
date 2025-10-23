package pconcurrente.ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(1,21);

        System.out.println("Pulsa enter cuando creas que el contador ha llegado a " + num);

        Contador c = new Contador();
        Thread t = new Thread(c);
        t.start();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        c.detener();

        if(c.getCuenta() == num){
            System.out.println("Lo has conseguido!");
        } else {
            System.out.printf("Vuelve a intentarlo, has detenido el contador en " + c.getCuenta());
        }
    }

}
