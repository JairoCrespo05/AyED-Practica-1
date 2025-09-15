package tp03.ejercicio6;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.PilaGenerica;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
	private T dato;
	private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
	private ArbolBinarioDeBusqueda<T> hijoDerecho;

	
	public ArbolBinarioDeBusqueda() {
		super();
	}

	public ArbolBinarioDeBusqueda(T dato) {
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
	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return this.hijoDerecho;

	}
	
	private void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijo) {
		this.hijoIzquierdo = hijo;

	}
	
	
	private void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijo) {
		this.hijoDerecho = hijo;

	}
	
	
	public boolean incluye (Comparable<T> dato){
		return this.buscar(dato, this) != null;
	}
	 
	
	public ArbolBinarioDeBusqueda<T> buscar (Comparable<T> x, ArbolBinarioDeBusqueda<T> arbol){
		if (arbol != null) {
			if (x.compareTo(arbol.getDato()) < 0) {
				arbol = this.buscar(x, arbol.getHijoIzquierdo());
			} else if (x.compareTo(arbol.getDato()) > 0) {
				arbol = this.buscar(x, arbol.getHijoDerecho());
			} else
				; // Se encontro el dato, asi que es arbol
			return arbol;
		} else {
			return null;
		}
	}
	 
	public void agregar (Comparable<T> dato){
		if (this.esVacio()){ //Si el arbol esta vacio entonces se setea el nuevo dato
			this.setDato((T) dato);
		}else {// delega al metodo privado recursivo para agregar en los hijos
			agregar(dato, this);
		}
	} 
	
	private void agregar (Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol) {
		if (dato.compareTo(arbol.getDato()) == 0) { //Si la comparacion da 0 entonces se reemplaza el valor actual por el nuevo
			arbol.setDato((T) dato);
			return;
		}
		//Si el dato es menor al actual dato entonces se va por el hijoIzquierdo
		if (dato.compareTo(arbol.getDato()) < 0) {
			if (arbol.tieneHijoIzquierdo()) {
				agregar(dato, arbol.hijoIzquierdo);
			}else {
				ArbolBinarioDeBusqueda<T> hijoIzq = new ArbolBinarioDeBusqueda<>( (T) dato);
				arbol.setHijoIzquierdo(hijoIzq);
			}
		}else { //si es mayor entonces va por el hijoDerecho
			if (arbol.tieneHijoDerecho()) {
				agregar(dato, arbol.hijoDerecho);
			}else {
				ArbolBinarioDeBusqueda<T> hijoDer = new ArbolBinarioDeBusqueda<>( (T) dato);
				arbol.setHijoDerecho(hijoDer);
			}
		}
	} 
	
	public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMayor (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMenorDeLosMayores (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMenor (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}

	public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> arbol){
		ListaGenerica<Integer> listaABB = new ListaEnlazadaGenerica<>();
		boolean encontrado = false;

		if (arbol.esVacio()){return null;}

		ArbolBinarioDeBusqueda<Integer> act = (ArbolBinarioDeBusqueda<Integer>) this;
		listaABB.agregarFinal(act.getDato());
		while (!act.esVacio() && !encontrado) {
			//si el dato del arbol comparado a mi arbol actual es menor a 0 entonces baja a la izquierda (menor a la raiz)
			if (arbol.getDato().compareTo((Integer) act.getDato()) < 0) {
				//niego el valor actual ya que bajo a la izquierda
//				listaABB.eliminarEn(listaABB.tamanio());
				listaABB.agregarFinal(-act.hijoIzquierdo.getDato());
				if (act.tieneHijoIzquierdo()) {
					act = act.getHijoIzquierdo();

				}  else {
					return null;
				}

				//si el dato del arbol comparado a mi arbol actual es mayor a 0 entonces baja a la Derecha (mayor a la raiz)
			} else if (arbol.getDato().compareTo((Integer) act.getDato()) > 0) {
				if (act.tieneHijoDerecho()) {
					listaABB.agregarFinal(act.hijoDerecho.getDato());
					act = act.getHijoDerecho();
				}  else {
					return null;
				}
			} else {
				encontrado = true;
				listaABB.eliminarEn(listaABB.tamanio());
			}

		}

		return listaABB;
	}


	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

}
