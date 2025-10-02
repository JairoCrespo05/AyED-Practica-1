package tp05;

public class MinHeap <T> implements ColaPrioridades <T>{

    private T[] datos;

    public MinHeap(){
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
