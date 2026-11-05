package pconcurrente.ejercicio8;

import java.util.ArrayList;

public class Contenedor {
    private ArrayList<Capsula> capsulas = new ArrayList<>();
    public synchronized void add(Capsula c){
        capsulas.add(c);
    }
    public synchronized int size(){
        return capsulas.size();
    }

    public synchronized void crearCaja(){
        for(int i = 0; i<6; i++){
            capsulas.remove(0);
        }
    }

}
