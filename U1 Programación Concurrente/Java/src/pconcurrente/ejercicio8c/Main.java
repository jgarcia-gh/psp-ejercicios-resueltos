package pconcurrente.ejercicio8c;

public class Main {
    public static void main(String[] args) {

        Contenedor c = new Contenedor();
        Thread tProductor1 = new Thread(new Productor(c, "Vainilla", 4));
        Thread tProductor2 = new Thread(new Productor(c, "Vainilla", 4));
        Thread tProductor3 = new Thread(new Productor(c, "Vainilla", 4));
        Thread tProductor4 = new Thread(new Productor(c, "Vainilla", 4));
        Thread tConsumidor = new Thread(new Consumidor(c));

        tProductor1.start();
        tProductor2.start();
        tProductor3.start();
        tProductor4.start();
        tConsumidor.start();

    }
}
