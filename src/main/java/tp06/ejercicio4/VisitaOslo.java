package tp06.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ejercicio1.Arista;
import tp06.ejercicio1.Grafo;
import tp06.ejercicio1.Vertice;
import tp06.ejercicio2.VerticeImplMatrizAdy;

public class VisitaOslo {

    public VisitaOslo(){

    }

    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String origen, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
        ListaGenerica<String> recorrido = new ListaEnlazadaGenerica<>();
        if(lugares.esVacio()){
            return recorrido;
        }
        ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();

        Vertice<String> vertOrigen = buscarOrigen(vertices, origen);

//PASO 1: BUSCO SI EL ORIGEN Y EL DESTINO EXISTEN

        if (vertOrigen == null){
            return recorrido;
        }

        boolean [] visitados = new boolean[vertices.tamanio()];

        //camino temporal para guardar el recorrido en la recursion
        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();

        dfsEspecifico(lugares, vertOrigen, destino, maxTiempo, 0, lugaresRestringidos, visitados, caminoActual, recorrido);

        return recorrido;
    }

    private boolean dfsEspecifico(Grafo<String> lugares, Vertice<String> actual,
                               String destino, int maxTiempo, int tiempoAcumulado,
                               ListaGenerica<String> lugaresRestringidos,
                               boolean[] visitados,
                               ListaGenerica<String> caminoActual,
                               ListaGenerica<String> recorrido){

        visitados[actual.getPosicion()] = true;
        recorrido.agregarFinal(actual.dato());

        ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(actual);
        //CASO BASE////////////////////////////////////////////////////////////////////////
        if(actual.dato().equals(destino)){
            if(tiempoAcumulado <= maxTiempo){
                //tomo el camino actual y lo seteo como camino final
                while (!caminoActual.fin()){
                    recorrido.agregarFinal(caminoActual.proximo());
                }
                //devuelvo true porque encontre un recorrido valido
                return true;
            }
        }
/// ///////////////////////////////////////////////////////////////////////////

        adyacentes.comenzar();
        while (!adyacentes.fin() ){
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> siguiente = arista.verticeDestino();
            int pesoSiguiente = arista.peso();

            if (!visitados[siguiente.getPosicion()] &&
            !lugaresRestringidos.incluye(siguiente.dato()) &&
            tiempoAcumulado + pesoSiguiente <= maxTiempo){

                boolean encontrado = dfsEspecifico(lugares, siguiente, destino, maxTiempo,
                        tiempoAcumulado + pesoSiguiente,
                        lugaresRestringidos, visitados, caminoActual, recorrido);

                if(encontrado){
                    return true;
                }
            }
        }

        // backtracking
        visitados[actual.getPosicion()] = false;
        caminoActual.eliminarEn(caminoActual.tamanio());
        return false;
    }

    private Vertice<String> buscarOrigen(ListaGenerica<Vertice<String>> vertices, String origen){
        boolean encontrado = false;
        Vertice<String> vertOrigen = null;
        while (!vertices.fin() && !encontrado){
            Vertice<String> actual = vertices.proximo();
            if (actual.dato().equals(origen)){
                vertOrigen = actual;
                encontrado = true;
            }
        }
        return vertOrigen;
    }


}
