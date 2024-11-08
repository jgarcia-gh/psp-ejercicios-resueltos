package pconcurrente.ejercicio8c;

public class Capsula {
    private String nombre;
    private int intensidad;

    public Capsula (String nombre, int intensidad){
        this.nombre = nombre;
        this.intensidad = intensidad;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", intensidad=" + intensidad;
    }
}
