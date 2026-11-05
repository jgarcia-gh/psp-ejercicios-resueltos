package pconcurrente.ejercicio18;

public class TareaCapturadora implements Runnable {

    Capturador c;

    public TareaCapturadora(String directorio){
        c= new Capturador(directorio);
    }

    @Override
    public void run() {
        c.RealizaCaptura();
    }
}
