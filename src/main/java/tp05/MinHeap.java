package tp05;

public class MinHeap <T extends Comparable<T>> implements ColaPrioridades <T> {

    private T[] datos;
    private int cantElementos;

    public MinHeap(){
        datos = (T[]) new Comparable[100];
        cantElementos = 0;
    }

    private void percolate_up(){
        T temp_dato = datos[cantElementos];
        int tamanio = cantElementos;
        while( (tamanio / 2 > 0) && (datos[tamanio/2].compareTo(temp_dato) > 0) ){
            datos[tamanio] = datos[tamanio/2];
            tamanio = tamanio/2;
        }
        datos[tamanio] = temp_dato;
    }

    private void percolate_down(int tamanio){
        int p = 1;
        T candidato = datos[p];
        boolean percolate_hecho = false;
        while(2*p <= tamanio && !percolate_hecho){
            int h_min = 2*p;
            if (h_min != tamanio){
                if (datos[h_min+1].compareTo(datos[h_min]) < 0){
                    h_min = h_min + 1;
                }
            }
            if (candidato.compareTo(datos[h_min]) > 0){
                datos[p] = datos[h_min];
                p = h_min;
            }else {
                percolate_hecho = true;
            }
            datos[p] = candidato;
        }
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
        if (esVacia()){
            return;
        }
        datos[0] = datos[cantElementos];
        cantElementos--;
        percolate_down(cantElementos);
    }

    @Override
    public boolean agregar(T elemento) {
        cantElementos++;
        datos[cantElementos] = elemento;
        percolate_up();
        return true;
    }

    @Override
    public T tope() {
        return datos[0];
    }
}
