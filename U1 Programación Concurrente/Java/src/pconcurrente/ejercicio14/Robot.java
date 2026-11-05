package pconcurrente.ejercicio14;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Robot implements Runnable {
    private List<Posicion> camino;
    private int posicionActual = 0;
    private String nombre;

    public Posicion getPosicionActual() {
        return camino.get(posicionActual);
    }

    public Robot(String nombre, List<Posicion> camino){
       this.camino = camino;
       this.nombre = nombre;
    }

    @Override
    public void run() {


        while(posicionActual != camino.size() - 1){
            Posicion siguientePosicion = camino.get(posicionActual + 1);
            if(siguientePosicion.entrar(this)){
                getPosicionActual().salir(this);
                posicionActual++;
            } else {
                /* Si no hemos podido avanzar porque la siguiente posición está ocupada, retrocederemos.
                    De este modo tratamos de evitar el interbloqueo y liberar la intersección.
                 */
                // Retrocedemos si podemos
                if(posicionActual - 1 >= 0) {
                    System.out.println(nombre + " Retrocediendo");
                    Posicion anteriorPosicion = camino.get(posicionActual - 1);
                    if (anteriorPosicion.entrar(this)) {
                        getPosicionActual().salir(this);
                        posicionActual--;
                        /* El objetivo de esta espera es "descincronizar" los robots interbloqueados de modo que evitemos
                        un nuevo interbloqueo. Al hacer la espera aleatoria, tratamos de evitar que vuelva a coincidir
                        en las intersecciones. El problema es que el tiempo tiene que ser elevado para que la diferencia entre
                        un robot y el otro sea de al menos 4500 milisegundos, que es el tiempo que un robot ocupa una intersección entrando (2000),
                        solicitando el bloqueo del cerrojo (500) y saliendo de la intersección (2000). Si la diferencia entre las esperas de ambos
                        robots no es superior a 4500 se volverá a producir un interbloqueo. Es por eso que esta solución no es la más óptima.
                        Otra opción sería establecer un sistema de prioridades o que el primer robot que bloquee el cerrojo de una intersección
                        también lo haga de las siguientes.
                         */
                        int espera = ThreadLocalRandom.current().nextInt(0, 30000);
                        System.out.println(nombre + " Espera aleatoria de " + espera + " para evitar un nuevo bloqueo");
                        try {
                            Thread.sleep(espera);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

        System.out.println(nombre + " RECORRIDO FINALIZADO");
    }

    @Override
    public String toString() {
        return nombre;
    }
}
