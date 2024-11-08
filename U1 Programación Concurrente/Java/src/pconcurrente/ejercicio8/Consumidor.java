package pconcurrente.ejercicio8;

public class Consumidor implements Runnable{

    private boolean ejecutar = true;
    private Contenedor contenedor;

    public Consumidor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    public void Detener(){
        ejecutar = false;
    }
    @Override
    public void run() {
            while(ejecutar){
                synchronized (contenedor){
                    while(contenedor.numeroCapsulas() < 6){
                        try {
                            contenedor.wait(); // Esperamos hasta que nos notifiquen que hay al menos 6 cápsulas
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");
                    contenedor.sacarCapsulas();
                    System.out.println("Hilo Consumidor: Caja creada");
                }
            }
    }
}
