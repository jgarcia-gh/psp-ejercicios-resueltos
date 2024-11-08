package examen.monitores.ejercicio1.solucion;

import java.util.ArrayList;

/*
Modifica el programa para que, cuando finalicen todos los hilos,
muestre por pantalla el número de elementos de la variable texto.

¿Se producen condiciones de carrera durante su ejecución?
En caso afirmativo, aplica los mencanismos de sincronización necesarios.
 */
public class Main {

    // La variable texto es compartida
    private static ArrayList<String> texto = new ArrayList<>();

    // Creamos un ArrayList para almacenar los hilos que creamos
    private static ArrayList<Thread> hilos = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                synchronized (hilos){ // Accedemos con bloque sincronizado
                    texto.add("Hola");
                }
                System.out.println(texto.size());
            });
            t.start();
            hilos.add(t);
        }
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                synchronized (hilos){ // Accedemos con bloque sincronizado
                    texto.add("Adiós");
                }
                System.out.println(texto.size());
            });
            t.start();
            hilos.add(t);
        }
        // Esperamos la finalización de todos los hilos
        for(Thread h: hilos){
            try {
                h.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Mostramos el número de elementos
        System.out.println("Número de elementos: " + texto.size());

    }
}
