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

	public boolean esMiDescendiente(T dato){
		if (this.esVacio()){
			return false;
		}

		if (this.tieneHijos()){
			while (!this.hijos.fin()){
				ArbolGeneral<T> hijoAct = this.hijos.proximo();

				if(hijoAct.getDato().equals(dato)) {
					return true;
				}

				if (hijoAct.esMiDescendiente(dato)){
					return true;
				}
			}
		}

		return false;
	}




	/// devuelve true si el valor a es ancestro   del valor b
	public boolean esAncestro(T a, T b){

		if (this.esVacio()){
			return false;
		}

		if (this.dato.equals(a)){
			return esMiDescendiente(b);
		}

		if (this.tieneHijos()){
			this.hijos.comenzar();
			while (!this.hijos.fin()){
				if (this.hijos.proximo().esAncestro(a, b)){
					return true;
				}
			}
		}
		return false;
	}

/// recorrido recursivo
	public boolean esArbolLleno(){
		if (this.esVacio()){
			return false;
		}

		return esArbolLleno(this, 0);
	}

	private boolean esArbolLleno(ArbolGeneral<T> arbol, int nivelActual){
		int nivelComparacion = nivelActual + 1;
		if (arbol.tieneHijos()){
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			int nivelHjos =0;
			while (!hijos.fin()){
				ArbolGeneral<T> hijoAct = hijos.proximo();
				nivelHjos = hijoAct.nivel(hijoAct.dato);

				if(nivelComparacion != nivelHjos){
					return false;
				}
			}
		}
		return true;
	}



	/// recorrido iterativo (verificar por niveles que no existan huecos)
	public boolean esArbolCompleto(){
		if (this.esVacio()){
			return false;
		}
		Integer grado = null;
		boolean hayHueco = false;

		ColaGenerica<ArbolGeneral> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		cola.encolar(this);

		while(!cola.esVacia()){

			int nodosXnivel = cola.tamanio();


			for (int i=0; i < nodosXnivel; i++){
				ArbolGeneral<T> arbol = cola.tope();
				cola.desencolar();

				int cantHijos = 0;
				if (arbol.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					cantHijos = hijos.tamanio();
					while(!hijos.fin()){
						cola.encolar(hijos.proximo());
					}
				}

				if(grado == null && cantHijos > 0){
					grado = cantHijos; // con el primer hijo se asigna el grado del Arbol
				}

				if (grado != null && cantHijos > grado){
					return false; //si existe una cantidad de hijos mayor al grado entonces no esta completo
				}

				if (!hayHueco){ // si no hay un hueco, compruebo que los sgtes nodos no tengan hijos, si los tienen NO ES COMPLETO
					if (grado != null && cantHijos < grado){
						hayHueco = true; //aparece el primer espacio
					}
				}else {
					if (cantHijos > 0){ //aparece un nodo con hijos despues del hueco, cosa que por regla de arbol completo no se puede
						return false;
					}
				}
			}
		}

		return true;
	}



}