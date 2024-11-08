package examen.monitores.ejercicio2.enunciado;

public class Cocinero implements Runnable{

    private Pedidos pedidos;

    public Cocinero(Pedidos pedidos){
        this.pedidos = pedidos;

    }

    @Override
    public void run() {
        while(true){
            if(pedidos.numeroPedidos() > 0){
                Pedido p = pedidos.extraerSiguientePedido();
                p.preparar();
                System.out.println("Cocinado pedido " + p.toString());
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
