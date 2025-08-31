package tp02.ejercicio1;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;


public class ArbolGeneral<T> {

	private T dato;
	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}

	/// nose si esta bien
	public Integer altura() {
		int alturaMax =0;
		if (!tieneHijos()){
			return 0;
		}
		this.hijos.comenzar();
		while(!this.hijos.fin()){
			ArbolGeneral<T> hijo = this.hijos.proximo();

			int alturaHijo =  hijo.altura();

			if (alturaHijo > alturaMax){
				alturaMax = alturaHijo;
			}
		}
		return 1 + alturaMax;
	}

	public Integer nivel(T dato) {
		if (this.esVacio()){
			System.out.println("Arbol Vacio");
			return -1;
		}

		return nivel(dato, 0);
	}

	/// -1 representa que el dato no se encontro
	private int nivel(T dato, int nivelActual) {
		int nivelMax = 0;
		if (this.getDato().equals(dato)) {
			return nivelActual;
		}

		if (tieneHijos()) {
			this.hijos.comenzar();
			while (!this.hijos.fin()) {
				int nivelDatoEncontrado = this.hijos.proximo().nivel(dato, nivelActual + 1);
				if (nivelDatoEncontrado != -1) {
					return nivelDatoEncontrado;
				}
			}
		}

		return -1;
	}


	public Integer ancho() {
		int maxNodos = 0;
		if (this.esVacio()){
			return maxNodos;
		}

		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		cola.encolar(this);

		while(!cola.esVacia()){

			int nodosXNivel = cola.tamanio();

			for (int i =0; i < nodosXNivel; i++){

				ArbolGeneral<T> actual = cola.tope();
				cola.desencolar();

				if (actual.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> hijos = actual.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
					}
				}

				if(maxNodos < nodosXNivel){
					maxNodos = nodosXNivel;
				}
			}
		}
		return maxNodos;
	}


}