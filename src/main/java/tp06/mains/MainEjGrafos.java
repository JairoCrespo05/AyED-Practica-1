package tp06.mains;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ejercicio1.Vertice;
import tp06.ejercicio2.GrafoImplMatrizAdy;
import tp06.ejercicio2.VerticeImplMatrizAdy;
import tp06.ejercicio4.VisitaOslo;

public class MainEjGrafos {
    public static void main(String[] args) {


        GrafoImplMatrizAdy<String> grafo = new GrafoImplMatrizAdy<>();

        // Crear vértices
        Vertice<String> ayuntamiento = new VerticeImplMatrizAdy<>("Ayuntamiento");
        Vertice<String> elTigre = new VerticeImplMatrizAdy<>("El Tigre");
        Vertice<String> museoMunch = new VerticeImplMatrizAdy<>("Museo Munch");
        Vertice<String> parqueBotanico = new VerticeImplMatrizAdy<>("Parque Botánico");
        Vertice<String> galeria = new VerticeImplMatrizAdy<>("Galería Nacional");
        Vertice<String> parqueVigeland = new VerticeImplMatrizAdy<>("Parque Vigeland");
        Vertice<String> folk = new VerticeImplMatrizAdy<>("FolkMuseum");
        Vertice<String> vikingo = new VerticeImplMatrizAdy<>("Museo Vikingo");

        grafo.agregarVertice(ayuntamiento);
        grafo.agregarVertice(elTigre);
        grafo.agregarVertice(museoMunch);
        grafo.agregarVertice(parqueBotanico);
        grafo.agregarVertice(galeria);
        grafo.agregarVertice(parqueVigeland);
        grafo.agregarVertice(folk);
        grafo.agregarVertice(vikingo);

        // Conexiones (simplificadas del gráfico)
        grafo.conectar(ayuntamiento, elTigre, 15);
        grafo.conectar(elTigre, museoMunch, 15);
        grafo.conectar(museoMunch, parqueBotanico, 1);
        grafo.conectar(parqueBotanico, galeria, 15);
        grafo.conectar(galeria, parqueVigeland, 10);
        grafo.conectar(parqueVigeland, folk, 20);
        grafo.conectar(folk, vikingo, 30);

        // Lugares restringidos
        ListaGenerica<String> restringidos = new ListaEnlazadaGenerica<>();
        restringidos.agregarFinal("Akker Brigge");
        restringidos.agregarFinal("Palacio Real");

        // Llamar método
        VisitaOslo visita = new VisitaOslo();
        ListaGenerica<String> camino = visita.paseoEnBici(grafo, "Ayuntamiento", "Museo Vikingo", 120, restringidos);

        System.out.println("=== Camino encontrado ===");
        camino.comenzar();
        while (!camino.fin()) {
            System.out.print(camino.proximo() + " -> ");
        }
        System.out.println("FIN");



    }
}
