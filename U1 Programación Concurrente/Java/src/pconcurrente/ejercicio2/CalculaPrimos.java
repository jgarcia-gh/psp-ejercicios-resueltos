package pconcurrente.ejercicio2;

import java.util.Random;

public class CalculaPrimos implements Runnable {
    @Override
    public void run() {

        Random r = new Random();
        int n = r.nextInt(100);
        System.out.println(Thread.currentThread().getName() + ": Mostrando primos hasta el " + n);

        for(int i = 1; i <= n; i++){
            if(esPrimo(i)){
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(499 + r.nextInt(501));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public boolean esPrimo(int n){
        boolean esPrimo = true && n > 1;
        for(int i = 2; i < n && esPrimo; i++){
            if(n%i == 0){
                esPrimo = false;
            }
        }
        return esPrimo;
    }
}
