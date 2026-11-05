package pconcurrente.ejercicio8b;

import java.util.ArrayList;
import java.util.Random;

public class Contenedor {
    private ArrayList<Capsula> capsulas = new ArrayList<>();
    public synchronized void add(Capsula c){
        capsulas.add(c);
    }
    public synchronized int size(){
        return capsulas.size();
    }

    public synchronized ArrayList<Capsula> extraerCapsulas(){
        ArrayList<Capsula> capsulasExtraidas = new ArrayList<>();
        for(int i = 0; i<6; i++){
            capsulasExtraidas.add(capsulas.remove(0));
        }
        return capsulasExtraidas;
    }

}
