package pconcurrente.ejercicio4;

public class Contador implements Runnable{

    boolean ejecutar = true;
    int cuenta = 0;

    public void detener(){
        ejecutar = false;
    }

    public int getCuenta(){
        return cuenta;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
                cuenta++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(ejecutar){
            try {
                Thread.sleep(1000);
                cuenta++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
