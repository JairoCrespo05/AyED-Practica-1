package tp03.ejercicio1;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int cantHojas = 0;
		if(this.esVacio()) { return 0; }

		if(this.esHoja()) { return 1; }

		if(this.tieneHijoIzquierdo()) {
			cantHojas += this.hijoIzquierdo.contarHojas();
		}

		if(this.tieneHijoDerecho()) {
			cantHojas += this.hijoDerecho.contarHojas();
		}

		return cantHojas;
	}


	public ArbolBinario<T> espejo() {
		if(this.esVacio()) { return null; }

		ArbolBinario<T> arbolEspejo = new ArbolBinario<T>(this.dato);

		if (this.tieneHijoIzquierdo()){
			arbolEspejo.agregarHijoDerecho(this.hijoIzquierdo.espejo());
		}

		if (this.tieneHijoDerecho()){
			arbolEspejo.agregarHijoIzquierdo(this.hijoDerecho.espejo());
		}

		return arbolEspejo;
	}


	public void entreNiveles(int n, int m){
		if(this.esVacio()) { return ;}

		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		cola.encolar(this);
		int nivel = 0;

		while(!cola.esVacia()){
			if (nivel > m){ return; }

			int nodosXnivel = cola.tamanio();

			for (int i =0; i<nodosXnivel;i++) {
				ArbolBinario<T> arbolAct = cola.tope();
				cola.desencolar();

				if (arbolAct.tieneHijoIzquierdo()) {
					cola.encolar(arbolAct.hijoIzquierdo);
				}
				if (arbolAct.tieneHijoDerecho()) {
					cola.encolar(arbolAct.hijoDerecho);
				}

				if (nivel >= n && nivel <= m){
					System.out.println(arbolAct.dato);
				}
			}
			nivel++;
		}
	}

	

}
