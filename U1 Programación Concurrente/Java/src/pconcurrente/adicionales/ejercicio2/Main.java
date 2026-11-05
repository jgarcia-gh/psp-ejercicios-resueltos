package pconcurrente.adicionales.ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Search> searches = new ArrayList<Search>();
    private static ArrayList<Thread> threads = new ArrayList<Thread>();
    private static ResultWriter resultWriter = new ResultWriter();
    private static boolean run = true;
    private static int numberOfSearches = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(run){
            System.out.println("1. Lanzar búsquedas.");
            System.out.println("2. Mostrar estado de las búsquedas.");
            System.out.println("3. Salir.");
            System.out.print("Elija una opción: ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    boolean moreSearches = true;
                    ArrayList<Search> newSearches = new ArrayList<Search>();
                    while(moreSearches){
                        System.out.print("Introduce el nombre del fichero: ");
                        String fileName = sc.nextLine();
                        System.out.print("Introduce la palabra a buscar: ");
                        String word = sc.nextLine();
                        numberOfSearches++;
                        Search s = new Search(numberOfSearches,fileName, word);
                        s.setResultWriter(resultWriter);
                        newSearches.add(s);
                        System.out.print("¿Deseas introducir una nueva búsqueda? (s/n): ");
                        moreSearches = sc.nextLine().equalsIgnoreCase("s");
                    }
                    System.out.println("Lanzando las búsquedas...");
                    for(Search s : newSearches){
                        searches.add(s);
                        Thread t = new Thread(s);
                        t.start();
                        threads.add(t);
                    }

                    break;
                }
                case 2: {
                    int counter = 1;
                    for (Search s : searches) {
                        System.out.println(s.getId() + " " + s.getFileName() + " " + s.getWord() + " " + s.getNumberResults() + " " + s.getState().toString());
                        counter++;
                    }
                    boolean showDetails = true;
                    while(showDetails){
                        System.out.print("Indica el número de la búsqueda sobre la que quieres ver los resultados o 0 para volver al menú: ");
                        int numResult = Integer.parseInt(sc.nextLine());
                        showDetails = numResult != 0;
                        if(showDetails){
                            if(numResult > 0 && numResult <= searches.size()){
                                Search s = searches.get(numResult - 1);
                                ArrayList<Result> results = s.getResults();
                                System.out.println("Resultados de la búsqueda: ");
                                for (Result r: results) {
                                    System.out.println("\t" +r.getLineNumber() + "\t" + r.getLine());
                                }
                            }
                        }
                    }
                    break;
                }
                case 3:{
                    for(Search s : searches){
                        s.stop();
                    }

                    for(Thread t : threads){
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resultWriter.close();
                    run = false;
                    break;
                }
                default:
                    System.out.println("La opción elegida no es válida.");
            }
        }

    }

}
