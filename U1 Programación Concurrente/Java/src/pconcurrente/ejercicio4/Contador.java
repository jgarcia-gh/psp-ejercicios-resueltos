package pconcurrente.ejercicio4;

public class Contador implements Runnable{

    boolean ejecutar = true;
    int cuenta = 1;

    public void detener(){
        ejecutar = false;
    }

    public int getCuenta(){
        return cuenta;
    }

    @Override
    public void run() {
        while(ejecutar){
            try {
                if(cuenta <=5) {
                    System.out.println(cuenta);
                }
                Thread.sleep(1000);
                cuenta++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
