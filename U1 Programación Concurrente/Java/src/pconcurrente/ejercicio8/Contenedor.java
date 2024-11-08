package pconcurrente.ejercicio8;

import java.util.ArrayList;

public class Contenedor {
    private ArrayList<Capsula> capsulas = new ArrayList<Capsula>();

    public void anyadirCapsula(Capsula c){
        capsulas.add(c);
    }

    public boolean sacarCapsulas(){
        boolean quitadas = false;
        if(capsulas.size() >= 6){
            for(int i = 0; i <= 5; i++){
                capsulas.remove(0);
            }
            quitadas = true;
        }
        return quitadas;
    }

    public int numeroCapsulas(){
        return capsulas.size();
    }
}
