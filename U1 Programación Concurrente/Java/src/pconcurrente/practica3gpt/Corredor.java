package pconcurrente.practica3gpt;

public class Corredor extends Thread {
    private int id;
    private Carril carril;
    private boolean tieneTestigo;

    public Corredor(int id, Carril carril, boolean tieneTestigo) {
        this.id = id;
        this.carril = carril;
        this.tieneTestigo = tieneTestigo;
    }

    public long getId() {
        return this.id;
    }

    public void setTieneTestigo(boolean tieneTestigo) {
        this.tieneTestigo = tieneTestigo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (tieneTestigo) {
                    // Avanza hasta encontrar el siguiente corredor
                    while (carril.avanzarCorredor(id)) {
                        Thread.sleep(10);  // Simular tiempo de avance
                    }

                    // Ver si puede pasar el testigo
                    Corredor siguienteCorredor = carril.puedePasarTestigo(id);
                    if (siguienteCorredor != null) {
                        System.out.println("Corredor " + id + " en el carril " + carril.getId() + " ha pasado el testigo.");
                        siguienteCorredor.setTieneTestigo(true);
                        break;  // Termina su carrera
                    }
                } else {
                    Thread.sleep(100);  // Esperar hasta recibir el testigo
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
