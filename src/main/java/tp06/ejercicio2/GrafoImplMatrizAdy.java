package tp06.ejercicio2;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ejercicio1.Arista;
import tp06.ejercicio1.Grafo;
import tp06.ejercicio1.Vertice;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {

    public static String EXISTE_VERTICE = "El Vertice existe";
    public static String NO_EXISTE_VERTICE = "El Vertice No existe";
    public static String GRAFO_LLENO = "El Grafo esta lleno";

    private int maxVertices;
    private ListaGenerica<Vertice<T>> vertices;
    private int[][] matrizAdyacencia;

    public GrafoImplMatrizAdy (){
        this.maxVertices = 0;
        this.vertices = new ListaEnlazadaGenerica<Vertice<T>>();
        this.matrizAdyacencia = new int[10][10];
    }


    @Override
    public void agregarVertice(Vertice<T> v) {
        if (existe(v)){
            throw new RuntimeException(EXISTE_VERTICE);
        }
        if (maxVertices >= matrizAdyacencia.length){
            throw new RuntimeException(GRAFO_LLENO);
        }

        v.setPosicion(maxVertices);
//        matrizAdyacencia[maxVertices][maxVertices] = 0;
//        vertices.comenzar();
        vertices.agregarFinal(v);
        maxVertices++;
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        vertices.comenzar();
        vertices.eliminar(v);
       matrizAdyacencia[v.getPosicion()][v.getPosicion()] = 0;

       maxVertices--;
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        if (!existe(origen)||!existe(destino)){
            throw new RuntimeException(NO_EXISTE_VERTICE);
        }
        //si el grafo es dirigido solo tendria que indicar de que fila hacia que columna es dirigido; ej origen --> destino; pero NO destino --> origen
        matrizAdyacencia[origen.getPosicion()][destino.getPosicion()] = 1;
//si descomento esto, el dfs funciona bien, pero si es dirigido 'D' no es adyacente de 'B' asi como asi
//        matrizAdyacencia[destino.getPosicion()][origen.getPosicion()] = 1;

        System.out.println("origen: " + origen.dato() + " (" + origen.getPosicion() + ")");
        System.out.println("destino: " + destino.dato() + " (" + destino.getPosicion() + ")");
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        if (!existe(origen)||!existe(destino)){
            throw new RuntimeException(NO_EXISTE_VERTICE);
        }

        matrizAdyacencia[origen.getPosicion()][destino.getPosicion()] = peso;
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        matrizAdyacencia[origen.getPosicion()][destino.getPosicion()] = 0;
    }

    /// #falta implementar
    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdyacencia[origen.getPosicion()][destino.getPosicion()] != 0; //esto por si es un grafo ponderado
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdyacencia[origen.getPosicion()][destino.getPosicion()];
    }

    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        vertices.comenzar();
        return this.vertices;
    }

/// #falta implementar
    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        ListaGenerica<Arista<T>> listaAdyacentes = new ListaEnlazadaGenerica<>();
        listaAdyacentes.comenzar();
        int origen = v.getPosicion();
        for (int j = 0; j < maxVertices; j++) {

            if(matrizAdyacencia[origen][j] != 0){
                /// #OJO CON ESTA PARTE
                Vertice<T> adyacente = vertices.elemento(j+1); ///esto debido a que ListaEnlazadaGenerica es 1 based y no es zero based,por lo que hay que adaptar el indice;
                Arista<T> arista = new AristaImpl<>(adyacente, matrizAdyacencia[origen][j]);

                listaAdyacentes.agregarFinal(arista);
            }
        }


        return listaAdyacentes;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        vertices.comenzar();
        /// #OJO CON ESTA PARTE
        return vertices.elemento(posicion+1); ///esto debido a que ListaEnlazadaGenerica es 1 based y no es zero based,por lo que hay que adaptar el indice;
    }

    public boolean existe(Vertice<T> vertice){ return this.vertices.incluye(vertice); }

}
