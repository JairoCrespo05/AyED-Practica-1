package tp05;

public class MaxHeap <T> implements ColaPrioridades<T>{

    private T[] datos;

    public MaxHeap(){
        datos = (T[]) new Comparable[100];
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
