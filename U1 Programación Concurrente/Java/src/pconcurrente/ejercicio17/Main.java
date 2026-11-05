package pconcurrente.ejercicio17;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numeroPartida = 0;

        while(true){
            System.out.print("¿Cuántos dados hay que lanzar?");
            int numDados = sc.nextInt();
            System.out.print("¿Qué resultados hay que obtener?");
            int[] objetivo = new int[numDados];
            for(int i = 0; i < numDados; i++){
                objetivo[i] = sc.nextInt();
            }
            System.out.println("Tengo que lanzar " +  numDados + ". Resultados a obtener: " + Arrays.toString(objetivo));
            ExecutorService es = Executors.newFixedThreadPool(2);
            es.execute(() ->{
                Random r = new Random();
                int obtenido[] = new int[numDados];
                int intento = 0;
                while(!Arrays.equals(objetivo, obtenido)){
                    intento ++;
                    for(int i  = 0; i < numDados; i++){
                        obtenido[i] = r.nextInt(1,7);
                    }
                    //System.out.println("Lanzamiento: " + Arrays.toString(obtenido));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Conseguido al intento " + intento + " ! " + Arrays.toString(obtenido));
            });
        }

    }
}
