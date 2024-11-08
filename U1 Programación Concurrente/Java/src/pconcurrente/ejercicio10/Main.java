package pconcurrente.ejercicio10;


import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la frecuencia con la que se tomarán las capturas en segundos: ");
        int frecuencia =  Integer.parseInt(sc.nextLine());

        System.out.print("Introduce el directorio donde se guardarán las capturas: ");
        String directorio = sc.nextLine();

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        TareaCapturadora c = new TareaCapturadora(directorio);
        ses.scheduleAtFixedRate(c, 0, frecuencia, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.print("Pulsa enter cuando quieras detener las capturas");
        sc.nextLine();
        ses.shutdown();
    }
}
