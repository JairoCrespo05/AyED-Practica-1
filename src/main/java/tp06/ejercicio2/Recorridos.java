package tp06.ejercicio2;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp06.ejercicio1.Arista;
import tp06.ejercicio1.Grafo;
import tp06.ejercicio1.Vertice;

public class Recorridos<T> {
	
	public Recorridos() {
		
	}
	
	
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> recorrido = new ListaEnlazadaGenerica<>();
		if (grafo.esVacio()){
			return recorrido;
		}

		ListaGenerica<Vertice<T>> listaVertices = grafo.listaDeVertices();
		boolean [] visitados = new boolean[listaVertices.tamanio()];
		listaVertices.comenzar();
		recorrido.comenzar();
		
		while(!listaVertices.fin()) {
			Vertice<T> actual = listaVertices.proximo();		

			if(!visitados[actual.getPosicion()]) {
				dfs(recorrido, grafo, actual, visitados);
			}
		}
		return recorrido;
	}
	
	
	private void dfs(ListaGenerica<Vertice<T>> recorrido, Grafo<T> grafo, Vertice<T> v, boolean [] visitados){
		visitados[v.getPosicion()] = true;
		recorrido.agregarFinal(v);

		ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);

		adyacentes.comenzar();
		while (!adyacentes.fin()){
			Vertice<T> destino = adyacentes.proximo().verticeDestino();
			if (!visitados[destino.getPosicion()]){
				dfs(recorrido, grafo, destino, visitados);
			}
		}
	}
	
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> visitados = new ListaEnlazadaGenerica<>();
		if (grafo.esVacio()) {
			return visitados;
		}

		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		vertices.comenzar();
		visitados.comenzar();

		ColaGenerica<Vertice<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		while (!vertices.fin()) {

			Vertice<T> origen = vertices.proximo();
			if (!visitados.incluye(origen)) {
				cola.encolar(origen);
				visitados.agregarFinal(origen);

				while (!cola.esVacia()) {

					Vertice<T> actual = cola.tope();
					cola.desencolar();

					if (!visitados.incluye(actual)) {
						ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(actual);

						adyacentes.comenzar();
						while (!adyacentes.fin()) {
							Arista<T> aristaAct = adyacentes.proximo();
							cola.encolar(aristaAct.verticeDestino());
							visitados.agregarFinal(aristaAct.verticeDestino());
						}
					}
				}
			}
		}
		return visitados;
	}


















}
