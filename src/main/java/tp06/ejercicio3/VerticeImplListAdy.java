package tp06.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ejercicio1.Arista;
import tp06.ejercicio1.Vertice;
import tp06.ejercicio2.AristaImpl;

public class VerticeImplListAdy<T> implements Vertice<T> {

    private T dato;
    private int posicion;
    private ListaGenerica<Arista<T>> adyacentes;

    public VerticeImplListAdy(T dato, int posicion){

        this.dato = dato;
        this.posicion = posicion;
        this.adyacentes = new ListaEnlazadaGenerica<>();
    }


    public void conectar(Vertice<T> v){
        this.adyacentes.agregarFinal(new AristaImpl<>(v, 0));
    }

    public void conectar(Vertice<T> v, int peso){
        this.adyacentes.agregarFinal(new AristaImpl<>(v, peso));
    }

    public void desconectar(Vertice<T> v){
        this.adyacentes.comenzar();
        while (!adyacentes.fin()){
            Arista<T> actual = adyacentes.proximo();
            if (actual.verticeDestino().equals(v)){
                adyacentes.eliminar(actual);
                System.out.println("vertice desconectado");
                return;
            }
        }
    }

    public ListaGenerica<Arista<T>> obtenerAdyacentes(){
        return this.adyacentes;
    }

    public boolean esAdyacente(Vertice<T> v){

        return true;
    }

    public int peso(Vertice<T> v){

        return 0;
    }


    public Arista<T> obtenerArista(Vertice<T> v){

        return null;
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
