package tp05;

public class MaxHeap <T extends Comparable<T>> implements ColaPrioridades<T>{

    private T[] datos;
    private int cantElementos;

    public MaxHeap(){
        datos = (T[]) new Comparable[100];
        cantElementos = 0;
    }

    private void percolate_up(){
        T newdato = datos[cantElementos];
        int tamanio = cantElementos;
        while( (tamanio / 2 > 0) && (datos[tamanio/2].compareTo(newdato) < 0) ){
            datos[tamanio] = datos[tamanio/2];
            tamanio = tamanio/2;
        }
        datos[tamanio] = newdato;
    }

    private void percolate_down(int tamanio){

    }

    public void imprimir(){
        for (int i=0; i < cantElementos; i++){
            System.out.println(datos[i]);
        }
    }

    @Override
    public boolean esVacia() {
        return cantElementos == 0;
    }

    @Override
    public void eliminar() {

    }

    @Override
    public boolean agregar(T elemento) {
        return false;
    }

    @Override
    public T tope() {
        return datos[0];
    }
}
