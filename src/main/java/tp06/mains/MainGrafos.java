package tp06.mains;

import tp06.ejercicio2.GrafoImplMatrizAdy;
import tp06.ejercicio2.VerticeImplMatrizAdy;
import tp06.ejercicio2.Recorridos;

public class MainGrafos {
    public static void main(String[] args) {

        var grafo = new GrafoImplMatrizAdy<String>();
        var v1 = new VerticeImplMatrizAdy<>("A");
        var v2 = new VerticeImplMatrizAdy<>("B");
        var v3 = new VerticeImplMatrizAdy<>("C");
        var v4 = new VerticeImplMatrizAdy<>("D");


//        var grafo = new GrafoImplListAdy<String>();
//        var v1 = new VerticeImplListAdy<>("A");
//        var v2 = new VerticeImplListAdy<>("B");
//        var v3 = new VerticeImplListAdy<>("C");
//        var v4 = new VerticeImplListAdy<>("D");


        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);


        System.out.println("v2 == v4 ? " + (v2 == v4));
        System.out.println("grafo contiene v4? " + grafo.listaDeVertices().incluye(v4));

        grafo.conectar(v1, v2);
        grafo.conectar(v1, v3);
        grafo.conectar(v2, v4);

        System.out.println("Posiciones de vértices:");
        System.out.println("A -> " + v1.getPosicion());
        System.out.println("B -> " + v2.getPosicion());
        System.out.println("C -> " + v3.getPosicion());
        System.out.println("D -> " + v4.getPosicion());



        // Crear objeto de recorridos
        Recorridos<String> recorridos = new Recorridos<>();


        System.out.println("=== Matriz de adyacencia ===");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grafo.peso(grafo.vertice(i), grafo.vertice(j)) + " ");
            }
            System.out.println();
        }


        // DFS
        var listaDFS = recorridos.dfs(grafo);
        System.out.println("=== Recorrido en profundidad (DFS) ===");
        listaDFS.comenzar();
        while (!listaDFS.fin()) {
            System.out.print(listaDFS.proximo().dato() + " ");
        }
        System.out.println();

        // BFS
        var listaBFS = recorridos.bfs(grafo);
        System.out.println("=== Recorrido en amplitud (BFS) ===");
        listaBFS.comenzar();
        while (!listaBFS.fin()) {
            System.out.print(listaBFS.proximo().dato() + " ");
        }
        System.out.println();
    }

}
