package pconcurrente.ejercicio8b;

public class Main {
    public static void main(String[] args) {

        Contenedor c = new Contenedor();
        Thread tProductor = new Thread(new Productor(c, "Vainilla", 4));
        Thread tConsumidor = new Thread(new Consumidor(c));

        tProductor.start();
        tConsumidor.start();

    }
}
