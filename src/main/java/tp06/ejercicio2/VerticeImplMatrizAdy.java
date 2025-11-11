package tp06.ejercicio2;

import tp06.ejercicio1.Vertice;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {

    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato){
        this.dato = dato;
        this.posicion = 0;
    }

    @Override
    public T dato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}
