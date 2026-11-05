package pconcurrente.ejercicio15;

import java.util.concurrent.locks.ReentrantLock;

/*
Indica por qué el funcionamiento no es correcto y cómo lo solucionarías:

    Si el documento es nulo —o si ocurre cualquier otra excepción—, el método interrumpirá su ejecución.
    Dado que la instrucción lock.unlock() se encuentra fuera del bloque finally, esta nunca llegará a ejecutarse,
    dejando el cerrojo retenido indefinidamente.

    Para solucionarlo, es necesario mover la liberación del cerrojo (lock.unlock()) al interior de un bloque finally,
    garantizando así su ejecución en cualquier escenario.

Una vez aplicada la solución  ¿Sería buena idea hacer el lock dentro del try? ¿Por qué?

    No sería buena idea. El método lock puede lanzar una excepción (por ejemplo, OutOfMemoryError o una interrupción del sistema).
    Si se diese el caso, pasaría a ejecutarse el bloque finally.

    El bloque finally intentaría ejecutar lock.unlock() sobre un cerrojo que nunca llegó a adquirirse, lanzando una segunda excepción
    (IllegalMonitorStateException) y ocultando la causa raíz del problema original.

 */

public class Impresora {
    private final ReentrantLock lock = new ReentrantLock();

    public void imprimirDocumento(String documento) {

        lock.lock();

        try {

            System.out.println("Imprimiendo: " + documento);

            // Simulación de un error durante la impresión
            if (documento == null) {
                throw new IllegalArgumentException("El documento no puede ser nulo");
            }

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        lock.unlock();
    }
}