package tp01.ejercicio3;

import tp01.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
    public static String COLA_VACIA = "Cola Vacia" ;

    private ListaGenerica<T> datos;
    private int tope;

    public ColaGenerica(ListaGenerica<T> datos){
        this.datos = datos;
    }

    public void encolar(T elemento){
        if (esVacia()){
            this.tope = 1;
        }else {
            this.tope++;
        }
        this.datos.comenzar();
        this.datos.agregarInicio(elemento);
    }

    public void desencolar(){
        if (esVacia()){
            throw new RuntimeException(COLA_VACIA);
        }
        this.datos.comenzar();
        this.datos.eliminarEn(tope);
        this.tope--;
    }

    public T tope(){
        if (esVacia()){
            throw new RuntimeException(COLA_VACIA);
        }
        
        return this.datos.elemento(tope);
    }

    public boolean esVacia(){
        return (tope <1);
    }
}
