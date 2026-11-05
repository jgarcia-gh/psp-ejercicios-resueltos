package pconcurrente.ejercicio9;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cbA = new CuentaBancaria();
        CuentaBancaria cbB = new CuentaBancaria();

        new Thread (() -> CuentaBancaria.transferir(cbA,cbB,200.0)).start();
        new Thread (() -> CuentaBancaria.transferir(cbB,cbA,50.0)).start();
    }
}
