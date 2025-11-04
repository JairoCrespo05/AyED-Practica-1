package tp06.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ejercicio1.Arista;
import tp06.ejercicio1.Grafo;
import tp06.ejercicio1.Vertice;
import tp06.ejercicio2.GrafoImplMatrizAdy;

public class GrafoImplListAdy<T> implements Grafo<T> {

    private static String NO_EXISTE_VERTICE = "No existe el vertice en este Grafo";
    private static String LISTA_VERTICES_VACIA = "No hay vertices en este Grafo";

    private ListaGenerica<Vertice<T>> vertices;

    public GrafoImplListAdy() {

        this.vertices = new ListaEnlazadaGenerica<>();
    }


    @Override
    public void agregarVertice(Vertice<T> v) {
        vertices.agregarFinal(v);
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        if(!existe(v)){
            throw new RuntimeException(NO_EXISTE_VERTICE);
        }

        vertices.eliminar(v);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        ((VerticeImplListAdy) origen).conectar(destino);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        ((VerticeImplListAdy) origen).conectar(destino, peso);

    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        ((VerticeImplListAdy) origen).desconectar(destino);
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {

        return ((VerticeImplListAdy) origen).esAdyacente(destino);
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return ((VerticeImplListAdy) origen).peso(destino);
    }

    @Override
    public boolean esVacio() {
        return this.vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.vertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        return ((VerticeImplListAdy) v).obtenerAdyacentes();
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        if (this.vertices.esVacia()){
            throw new RuntimeException(LISTA_VERTICES_VACIA);
        }

        this.vertices.comenzar();
        return this.vertices.elemento(posicion);
    }

    public boolean existe(Vertice<T> v){
        return this.vertices.incluye(v);
    }
}
