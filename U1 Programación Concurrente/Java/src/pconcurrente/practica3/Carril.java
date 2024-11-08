package pconcurrente.practica3;

import java.util.HashMap;

public class Carril {

    private int id;
    public int getId(){
        return id;
    }
    private int [] carril = new int [400000];
    private HashMap<Integer, Integer> idToPosition = new HashMap<Integer, Integer>();
    private HashMap<Integer, Corredor> idToCorredor = new HashMap<Integer, Corredor>();

    public Carril(int id){
        this.id = id;
    }
    public boolean añadirCorredor(Corredor c, int posicion){
        carril[posicion] = c.getId();
        idToPosition.put(c.getId(),posicion);
        idToCorredor.put(c.getId(),c);
        return true;
    }

    public boolean avanzarCorredor(int idCorredor){

        boolean puedeAvanzar = true;

        int posActual = idToPosition.get(idCorredor);
        int nuevaPos = posActual + 1;
        if(nuevaPos < carril.length && carril[nuevaPos] == 0 ){
            idToPosition.put(idCorredor,nuevaPos);
            carril[posActual] = 0;
            carril[nuevaPos] = idCorredor;
        } else{
            puedeAvanzar = false;
        }
        return puedeAvanzar;

    }

    public Corredor puedePasarTestigo(int idCorredor){
        int idSiguienteCorredor = -1;
        int posActual = idToPosition.get(idCorredor);
        int posSig = posActual + 1;
        if(posSig < carril.length && carril[posSig] != 0){
            idSiguienteCorredor = carril[posSig];
            return idToCorredor.get(idSiguienteCorredor);
        } else {
            return null;
        }
    }

    public int obtenerPosicion(int idCorredor){
        return idToPosition.get(idCorredor);
    }


}
