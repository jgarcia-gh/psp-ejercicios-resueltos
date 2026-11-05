package pconcurrente.ejercicio10;

public class Coordinador {

    public static void utilizarRecursos(Recurso r1, Recurso r2) {
        Recurso primero = r1.getId() < r2.getId()? r1 : r2;
        Recurso segundo = r1.getId() < r2.getId()? r2 : r1;

        synchronized (primero) {
            System.out.println(Thread.currentThread().getName() + " adquirió el primero.");
            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (segundo) {
                System.out.println(Thread.currentThread().getName() + " adquirió ambos. Trabajando...");
            }
        }
    }
}
