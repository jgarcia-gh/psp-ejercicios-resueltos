package ejercicio2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HiloEnvia implements Runnable{
    private Socket socket;
    public HiloEnvia(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {

        String mensajeAEnviar = "";
        try (Scanner sc = new Scanner(System.in);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream, true);){

            System.out.println("ENVIA");
                while(!mensajeAEnviar.equals("fin")) {
                    System.out.println("ENVIA2");
                    // Enviamos mensaje
                    System.out.print("Escribe el mensaje a enviar: ");
                    mensajeAEnviar = sc.nextLine();
                    printWriter.println(mensajeAEnviar);
                }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
