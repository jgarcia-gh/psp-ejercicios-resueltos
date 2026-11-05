package pconcurrente.ejercicio14;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Interseccion extends Posicion {
    private final ReentrantLock lock = new ReentrantLock(true); // Fairness para que pasen en orden de llegada
    private Robot robotEnInterseccion;

    public Interseccion(String nombre) {
        super(Tipo.INTERSECCION, nombre);
    }

    public boolean entrar(Robot r) {
        System.out.println("Robot " + r + " intentando entrar en " + nombre );

        try {
            /* Hacemos que se espere hasta 500 milisegundos a que se libere la intersección, de esta forma evitamos
            * intentar bloquear el cerrojo de forma continuada en el caso de que esté ocupado. */
            if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {

                if (robotEnInterseccion != null && robotEnInterseccion != r) {
                    System.out.println("COLISION ENTRE ROBOTS");
                    throw new RuntimeException();
                }
                robotEnInterseccion = r;

                System.out.println("Robot " + r + " entrando en " + nombre);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("Robot " + r + " en " + nombre);
                return true;
            } else {
                /* Si transcurrido ese tiempo, no podemos bloquarlo, significa que está ocupado, devolveremos false*/
                System.out.println("Robot " + r + " no puede entrar en " + nombre);
            }
        } catch(InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }
        return false;
    }
    public void salir(Robot r) {
        System.out.println("Robot " + r + " saliendo de " + nombre );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Robot " + r + " ha salido de " + nombre );
        robotEnInterseccion = null;
        lock.unlock();
    }
}
