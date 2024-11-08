package pconcurrente.practica3gpt;

import java.util.concurrent.ConcurrentHashMap;

public class Carril {
    private int id;
    private static final int LONGITUD = 400000;
    private ConcurrentHashMap<Integer, Corredor> posiciones;  // Almacenará la posición y el corredor correspondiente

    public Carril(int id) {
        this.id = id;
        this.posiciones = new ConcurrentHashMap<>();
    }

    // Añadir corredor a una posición del carril
    public synchronized boolean añadirCorredor(Corredor corredor, int posicion) {
        if (!posiciones.containsKey(posicion)) {
            posiciones.put(posicion, corredor);
            return true;
        }
        return false;
    }

    // Avanzar corredor si la posición siguiente está libre
    public synchronized boolean avanzarCorredor(int corredorId) {
        int posicionActual = obtenerPosicion(corredorId);
        if (posicionActual == -1 || posicionActual >= LONGITUD) return false;  // Ya ha llegado a la meta

        int nuevaPosicion = posicionActual + 1;
        if (!posiciones.containsKey(nuevaPosicion)) {
            Corredor corredor = posiciones.remove(posicionActual);  // Remover de la posición actual
            posiciones.put(nuevaPosicion, corredor);  // Añadir en la nueva posición
            return true;
        }
        return false;
    }

    // Comprobar si se puede pasar el testigo
    public synchronized Corredor puedePasarTestigo(int corredorId) {
        int posicionActual = obtenerPosicion(corredorId);
        Corredor siguienteCorredor = posiciones.get(posicionActual + 1);
        return siguienteCorredor;
    }

    // Obtener la posición de un corredor
    public synchronized int obtenerPosicion(int corredorId) {
        for (int posicion : posiciones.keySet()) {
            if (posiciones.get(posicion).getId() == corredorId) {
                return posicion;
            }
        }
        return -1;  // No encontrado
    }

    // Identificador del carril
    public int getId() {
        return this.id;
    }
}