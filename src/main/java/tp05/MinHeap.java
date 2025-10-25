package tp05;

public class MinHeap <T extends Comparable<T>> implements ColaPrioridades <T> {

    private T[] datos;
    private int cantElementos;

    public MinHeap(){
        this.datos = (T[]) new Comparable[100];
        this.cantElementos = 0;
    }

    /// el cantElementos -1, al igual que i - 1, se deben a que el array es zero based por lo que en realidad debo posicionarme 1 posicion antes
    /// debido a que el primer elemento se encuentra en la posicion 0 y no en la posicion 1 como nos indicaria cantElementos
    private void percolate_up(){
        T temp_dato = datos[cantElementos - 1];
        int i = cantElementos - 1;

        while( (i > 0) && (datos[(i - 1) /2 ].compareTo(temp_dato) > 0) ){
            datos[i] = datos[(i - 1) /2 ];
            i = (i - 1) /2;
        }

        datos[i] = temp_dato;
    }
    

    private void percolate_down(int tamanio){
        int p = 0;
        T candidato = datos[p];
        boolean percolate_hecho = false;

        while(2 * p + 1 < tamanio && !percolate_hecho){
            int h_min = 2 * p + 1;
            int h_der = h_min + 1; // o (2 * p +2)

            //Si hay hijo derecho y es menor que el izquierdo
            if (h_der < tamanio && datos[h_der].compareTo(datos[h_min]) < 0){
                h_min = h_der;
            }

            // Comparar candidato con el hijo menor
            if (candidato.compareTo(datos[h_min]) > 0) {
                datos[p] = datos[h_min];
                p = h_min;

            } else {
                percolate_hecho = true;
            }
        }

        datos[p] = candidato;
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
            throw new RuntimeException("Heap Vacia");
        }
        this.datos[0] = this.datos[cantElementos - 1];
        this.cantElementos--;
        percolate_down(cantElementos);
    }

    @Override
    public boolean agregar(T elemento) {
        if(cantElementos >= datos.length){
            throw new RuntimeException("Heap Lleno");
        }

        this.datos[cantElementos] = elemento;
        this.cantElementos++;
        percolate_up();

        return true;
    }

    @Override
    public T tope() {
        return datos[0];
    }
}
