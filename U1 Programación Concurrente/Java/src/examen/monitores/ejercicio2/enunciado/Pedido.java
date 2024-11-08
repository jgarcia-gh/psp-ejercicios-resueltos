package examen.monitores.ejercicio2.enunciado;


public class Pedido {
    private int id;
    private TipoPizza tipoPizza;
    private boolean preparado = false;
    public Pedido(int id, TipoPizza tipoPizza){
        this.id = id;
        this.tipoPizza = tipoPizza;
    }

    public void preparar(){
        preparado = true;
    }

    @Override
    public String toString() {
        return id + " " + tipoPizza.toString() + " Preparado: " + preparado;
    }
}
