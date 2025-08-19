package tp01.ejercicio1;

public class ListaDeEnterosConArreglos extends ListaDeEnteros {
	private int tamanio;
	private Integer[] datos = new Integer[30];
	/// Si paso el limite del vector de datos me da una exception de tipo ArrayIndexOutOfBounds
	/// debido a que es una lista estatica
//	private Integer[] datos = new Integer[3];
	private int actual = 0;

	@Override
	public void comenzar() {
		actual = 0;
	}

	@Override
	public Integer proximo() {
		return datos[actual++];
	}

	@Override
	public boolean fin() {
		return actual == tamanio;
	}

	@Override
	public Integer elemento(int pos) {
		return datos[pos - 1];
	}

	@Override
	// Se considera pos 1 al indice 0
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 1 || pos > tamanio + 1 || pos > datos.length
				|| tamanio == datos.length)
			return false;
		tamanio++;
		for (int i = tamanio - 1; i >= pos; i--)
			datos[i] = datos[i - 1];
		datos[pos - 1] = elem;
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		
		return this.agregarEn(elem, 1); 
	}

	@Override
	public boolean eliminar(Integer elem) {
		
		boolean encontre = false;
		int i = 0;
		while (i < tamanio && !encontre) {
			if (datos[i].equals(elem)) {
				eliminarEn(i+1);
				encontre = true;
			}
			i++;
		}
		return encontre;
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > tamanio)
			return false;
		tamanio--;
		for (int i = pos - 1; i < tamanio; i++)
			datos[i] = datos[i + 1];
		return true;
	}

	
	@Override
	public boolean esVacia() {
		
		return (tamanio==0);
	}


	@Override
	public boolean agregarFinal(Integer elem) {
		tamanio++;
		datos[tamanio-1]=elem;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {

		int i=0;
		while (i<tamanio){
			/// si se usa equals en vez de "==" en el if no se produce ningun false con int o Integer
//			if (datos[i].equals(elem))
			if (datos[i]==elem){
				return true;
			}
			i++;
		}
		return false;
	}


	@Override
	public int tamanio() {
		return tamanio;
	}


	/// Mi Metodo
	public void mostrarElementosRecursivo(ListaDeEnterosConArreglos lista){

		if (lista.esVacia()){
			System.out.println("Lista vacia");
			return;
		}

		if (lista.fin()) {
			System.out.println("fin del la lista");
			return;
		}

		int elemento = lista.elemento(actual+1);
		System.out.println("iterando lista");
		lista.proximo();
		mostrarElementosRecursivo(lista);

		System.out.println("Elemento:");
		System.out.println(elemento);
	}


}
