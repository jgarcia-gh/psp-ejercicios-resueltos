package pconcurrente.ejercicio8b;

import java.util.ArrayList;

public class Contenedor {
    private ArrayList<Capsula> capsulas = new ArrayList<Capsula>();

    public void anyadirCapsula(Capsula c){
        capsulas.add(c);
    }

    public boolean sacarCapsulas(){
        boolean quitadas = false;
        if(capsulas.size() >= 6){
            for(int i = 5; i>= 0; i--){
                capsulas.remove(i);
            }
            quitadas = true;
        }
        return quitadas;
    }

    public int numeroCapsulas(){
        return capsulas.size();
    }
}
