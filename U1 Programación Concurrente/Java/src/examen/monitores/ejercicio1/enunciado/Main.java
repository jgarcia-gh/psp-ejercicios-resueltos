package examen.monitores.ejercicio1.enunciado;

import java.util.ArrayList;
/*
Modifica el programa para que, cuando finalicen todos los hilos,
muestre por pantalla el número de elementos de la variable texto.

¿Se producen condiciones de carrera durante su ejecución?
En caso afirmativo, aplica los mencanismos de sincronización necesarios.
 */
public class Main {

    private static ArrayList<String> texto = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                texto.add("Hola");
            });
            t.start();
        }
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                texto.add("Adiós");
            });
            t.start();
        }

        System.out.println("Número de elementos: " + texto.size());
    }
}
