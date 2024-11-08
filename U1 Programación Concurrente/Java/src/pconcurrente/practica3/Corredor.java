package pconcurrente.practica3;

public class Corredor implements Runnable{

    private boolean tieneTestigo = false;
    public void recibirTestigo(){
        if(!tieneTestigo){
            System.out.println("Pista " + carril.getId() + " Corredor " + id + ": Recibo el testigo");
            tieneTestigo = true;
        }
    }
    public void perderTestigo(){
        if(tieneTestigo){
            System.out.println("Pista " + carril.getId() + " Corredor " + id + ": Pierdo el testigo");
            tieneTestigo = false;
        }
    }

    private boolean haCorrido = false;
    private int id;
    public int getId(){
        return id;
    }
    private Carril carril;
    public Corredor(int id, Carril p, boolean esPrimerCorredor){
        if(esPrimerCorredor){
            tieneTestigo = true;
        }
        this.id = id;
        this.carril = p;
    }

    @Override
    public void run() {

        while(!tieneTestigo){
            try {
                //System.out.println("Carril " + carril.getId() + " Corredor " + id + ": A la espera de recibir el testigo");
                synchronized (carril) {
                    carril.wait();
                    //System.out.println("Carril " + carril.getId() + " Corredor " + id + ": Me han despertado." + (tieneTestigo? "Tengo el testigo": "No tengo el testigo"));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Carril " + carril.getId() + " Corredor " + id + ": Tengo el testigo y empiezo a correr");
        while(tieneTestigo && !haCorrido && carril.avanzarCorredor(id)){
            Corredor siguienteCorredor = carril.puedePasarTestigo(id);
            if(siguienteCorredor != null){
                this.perderTestigo();
                siguienteCorredor.recibirTestigo();
                synchronized (carril){
                    carril.notifyAll();
                }
                haCorrido = true;
            }
        }

        System.out.println("Carril " + carril.getId() + " Corredor " + id + ": He terminado de correr. Posición final: " + carril.obtenerPosicion(id));


    }
}
