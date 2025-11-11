package tp06.ejercicio2;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ejercicio1.Arista;
import tp06.ejercicio1.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {

    private static String LISTA_ADYACENTES_VACIA = "La lista de adyacentes esta vacia";
    private static String VERTICE_DESCONECTADO = "El vertice fue desconectado";

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
        Arista<T> actual = obtenerArista(v);
        adyacentes.eliminar(actual);
        System.out.println(VERTICE_DESCONECTADO);
    }

    public ListaGenerica<Arista<T>> obtenerAdyacentes(){
        this.adyacentes.comenzar();
        return this.adyacentes;
    }

    public boolean esAdyacente(Vertice<T> v){
        if(obtenerArista(v) == null) {
            return false;
        }

        return true;
    }

    public int peso(Vertice<T> v){

        return obtenerArista(v).peso();
    }


    public Arista<T> obtenerArista(Vertice<T> v){
        boolean encontrado = false;
        Arista<T> actual = null;

        this.adyacentes.comenzar();

        if(this.adyacentes.esVacia()) {
            throw new RuntimeException(LISTA_ADYACENTES_VACIA);
        }

        while(!this.adyacentes.fin() && !encontrado ){
            actual = this.adyacentes.proximo();
            if(actual.verticeDestino().equals(v)) {
                encontrado = true;
            }
        }

        return actual;
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
