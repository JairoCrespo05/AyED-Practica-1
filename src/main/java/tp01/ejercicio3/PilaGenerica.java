package tp01.ejercicio3;

import tp01.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
    public static String PILA_VACIA = "Pila Vacia";

    private ListaGenerica<T> datos;
    private int tope;

    public PilaGenerica(ListaGenerica<T> datos) {
        this.datos = datos;

    }

    public void apilar(T elemento){
        if(esVacia()){
            this.tope = 1;
        }else {
            this.tope++;
        }
        this.datos.comenzar();
        this.datos.agregarFinal(elemento);
    }

    public T desapilar(){
        T topeP;
        if (esVacia()){
            throw new RuntimeException(PILA_VACIA);
        }
        this.datos.comenzar();
        topeP = this.datos.elemento(this.tope);
        this.datos.eliminarEn(this.tope);
        this.tope--;

        return topeP;
    }

    public T tope(){
        if (esVacia()){
            throw new RuntimeException(PILA_VACIA);
        }
        return this.datos.elemento(this.tope);
    }

    public boolean esVacia() {
        return (tope < 1);
    }

}
