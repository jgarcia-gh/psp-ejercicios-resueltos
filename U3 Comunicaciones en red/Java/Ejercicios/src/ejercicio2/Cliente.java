package ejercicio2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        System.out.println("---CLIENTE---");

        Socket cliente = new Socket("localhost", 1234);

        HiloEnvia he = new HiloEnvia(cliente);
        Thread t1 = new Thread(he);
        HiloRecibe hr = new HiloRecibe(cliente);
        Thread t2 = new Thread(hr);

        t1.start();
        t2.start();

        try {
            t1.join();
            hr.detener();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}