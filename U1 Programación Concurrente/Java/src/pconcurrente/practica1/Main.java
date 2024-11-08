package pconcurrente.practica1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<FolderWatcher> watchers = new ArrayList<>();
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1. Añadir monitor");
            System.out.println("2. Detener monitor");
            System.out.println("3. Mostrar en tiempo real ");
            System.out.println("4. Mostrar histórico");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    AddWatcher();
                    break;
                case 2:{
                    int count = 1;
                    for(FolderWatcher fw : watchers){
                        System.out.println(count + ". " + fw.getPath());
                    }
                    System.out.print("Indica el número del monitor a detener: ");
                    int numWatcher = Integer.parseInt(sc.nextLine());
                    if(numWatcher > 0 && numWatcher <= watchers.size()){
                        watchers.get(numWatcher-1).detener();
                        watchers.remove(numWatcher-1);
                    } else {
                        System.out.println("Número incorrecto");
                    }
                    break;
                } case 3:
                    ShowRealTimeEvents();
                    break;
                case 4:{
                    int count = 1;
                    System.out.print("Monitores disponibles: ");
                    for(FolderWatcher fw : watchers){
                        System.out.println(count + ". " + fw.getPath());
                    }
                    System.out.print("Indica el número del monitor del que quieres obtener el histórico: ");
                    int numWatcher = Integer.parseInt(sc.nextLine());
                    if(numWatcher > 0 && numWatcher <= watchers.size()){
                        watchers.get(numWatcher-1).showHistorical();
                    } else {
                        System.out.println("Número incorrecto");
                    }
                    break;
                }
            }
        } while(opcion != 5);
    }

    public static void AddWatcher(){
        System.out.print("Indica la ruta: ");
        File f = new File(sc.nextLine());
        if(f.exists()){
            FolderWatcher fw = new FolderWatcher(f);
            executor.execute(fw);
            watchers.add(fw);
        }
    }

    public static void ShowRealTimeEvents(){
        for (FolderWatcher fw: watchers) {
            fw.setShowLiveLog(true);
        }
        System.out.println("Pulsa enter cuando quieras volver al menú");
        sc.nextLine();

        for (FolderWatcher fw: watchers) {
            fw.setShowLiveLog(false);
        }
    }
}
