package examen.monitores.ejercicio2.enunciado;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Pedidos pedidos = new Pedidos();

        for (int i = 0; i < 5; i++) {
            Thread h = new Thread(new Cocinero(pedidos));
            h.start();
        }

        ArrayList<Pedido> todosPedidos = pedidos.obtenerTodosPedidos();

        Thread t = new Thread(()->{
            for(int i = 0; i < 100; i++){
                if(i%2==0){
                    todosPedidos.add(new Pedido(i, TipoPizza.Barbacoa));
                } else {
                    todosPedidos.add(new Pedido(i, TipoPizza.Hawaiana));
                }
            }
        });

        t.start();
    }
}
