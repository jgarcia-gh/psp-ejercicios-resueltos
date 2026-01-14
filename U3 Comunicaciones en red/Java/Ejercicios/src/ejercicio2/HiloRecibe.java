package ejercicio2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiloRecibe implements Runnable{
    private Socket socket;
    private boolean ejecutar = true;
    public void detener(){
        ejecutar = false;
    }
    public HiloRecibe(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
            String lineaRecibida  = "";
        //System.out.println("RECIBE");
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));){

                //System.out.println("RECIBE1");
                while(ejecutar){
                    //System.out.println("RECIBE2");
                    lineaRecibida = bufferedReader.readLine();
                    if (lineaRecibida == null) {
                        detener(); // Esto termina el ciclo si no hay más mensajes
                    } else {
                        System.out.println("El mensaje recibido es: " + lineaRecibida);
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
    }
}
