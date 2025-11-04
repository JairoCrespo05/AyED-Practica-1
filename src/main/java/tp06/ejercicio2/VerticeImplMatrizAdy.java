package tp06.ejercicio2;

import tp06.ejercicio1.Vertice;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {

    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato){
        this.dato = dato;
        int posicion = 0;
    }

    @Override
    public T dato() {
        return null;
    }

    @Override
    public void setDato(T dato) {

    }

    @Override
    public int getPosicion() {
        return 0;
    }

    @Override
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

//    public void setPosicion(int posicion) {
//        this.posicion = posicion;
//    }

}
