package tp05;

public class MinHeap <T> implements ColaPrioridades <T>{

    private T[] datos;
    private int cantElementos;

    public MinHeap(){
        datos = (T[]) new Comparable[100];
        cantElementos = 0;
    }

    private void percolate_up(){

    }

    private void percolate_down(int tamanio){

    }

    public void imprimir(){

    }

    @Override
    public boolean esVacia() {
        return false;
    }

    @Override
    public void eliminar() {

    }

    @Override
    public boolean agregar(Object elemento) {
        return false;
    }

    @Override
    public void tope() {

    }
}
