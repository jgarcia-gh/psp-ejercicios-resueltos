package ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        System.out.println("---SERVIDOR---");

        try{
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Esperando conexión de un cliente...");
            while(true) { // Poner un while(true) no es la mejor práctica, pero se ha hecho así con el objeto de simplificar el código
                try {
                    Socket conexionCliente = server.accept();
                    System.out.println("¡Cliente conectado!");

                    HiloEnvia he = new HiloEnvia(conexionCliente);
                    Thread t1 = new Thread(he);
                    HiloRecibe hr = new HiloRecibe(conexionCliente);
                    Thread t2 = new Thread(hr);

                    t1.start();
                    t2.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}