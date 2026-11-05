package pconcurrente.ejercicio8d;

import java.util.ArrayList;

public class Contenedor {
    private ArrayList<Capsula> capsulas = new ArrayList<>();
    public synchronized void add(Capsula c){
        while(capsulas.size() >= 100){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        capsulas.add(c);

        if(capsulas.size()>=6){
            notifyAll();
        }
    }
    public synchronized int size(){
        return capsulas.size();
    }

    public synchronized ArrayList<Capsula> extraerCapsulas(){

        while(capsulas.size()<6){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        ArrayList<Capsula> capsulasExtraidas = new ArrayList<>();
        for(int i = 0; i<6; i++){
            capsulasExtraidas.add(capsulas.remove(0));
        }

        notifyAll();

        return capsulasExtraidas;
    }

}
