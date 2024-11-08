package examen.monitores.ejercicio2.enunciado;

import java.util.ArrayList;

public class Pedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    public Pedido extraerSiguientePedido(){
        return pedidos.remove(0);
    }
    public ArrayList<Pedido> obtenerTodosPedidos(){ return pedidos;}
    public int numeroPedidos(){ return pedidos.size();}
}
