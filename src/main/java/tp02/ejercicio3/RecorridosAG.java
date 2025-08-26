package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.ejercicio1.ArbolGeneral;

public class RecorridosAG {

    private ListaGenerica listaNros;

    public RecorridosAG(){

    }


    /// IN-ORDEN
    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQueInOrden(a, n, listaImpares);

        return listaImpares;
    }

    /// POST-ORDEN
    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQuePostOrden(a, n, listaImpares);

        return listaImpares;
    }

    ///POR NIVELES
    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles (ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQuePorNiveles(a, n, listaImpares);

        return listaImpares;
    }

    ///PRE-ORDEN
    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQuePreOrden(a, n, listaImpares);

        return listaImpares;
    }

    ///PRE-ORDEN
    private ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> listaNros){
        //caso base recorre hasta encontrar un arbol nulo y que no tenga hijos
        if (a.esVacio()){
            return listaNros;
        }
        int datoActual = a.getDato();
        if (datoActual % 2 != 0 && datoActual > n){
            listaNros.agregarFinal(datoActual);
        }
        if (a.tieneHijos()){
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();

            while(!hijos.fin()){
                numerosImparesMayoresQuePreOrden(hijos.proximo(), n, listaNros);
            }
        }

        return listaNros;
    }

    /// IN-ORDEN
    private ListaGenerica< Integer > numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> listaNros){
        //caso base recorre hasta encontrar un arbol nulo y que no tenga hijos
        if (a.esVacio()){
            return listaNros;
        }

        //obtengo todos los hijos
        ListaGenerica <ArbolGeneral<Integer>> hijos = a.getHijos();
        hijos.comenzar();

        //si tengo hijos, obtengo el primer hijo y sigo bajando de niveles
        if (!hijos.fin()){
            ArbolGeneral<Integer> hijoIzq = hijos.proximo();
            numerosImparesMayoresQueInOrden(hijoIzq, n, listaNros);
        }

        //proceso la raiz luego del HIzq, en caso de NO tener hijos esta seria el bloque de codigo cuando es una hoja
        int datoActual = a.getDato();
        if (datoActual % 2 != 0 && datoActual > n){
            listaNros.agregarFinal(datoActual);
        }

        //recorro los demas hijos si es que tengo, sino devuelvo la lista en el return de abajo
        while (!hijos.fin()){
            numerosImparesMayoresQueInOrden(hijos.proximo(), n, listaNros);
        }

        return listaNros;
    }

    /// POST-ORDEN
    private ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> listaNros){
        //caso base recorre hasta encontrar un arbol nulo y que no tenga hijos
        if (a.esVacio()){
            return listaNros;
        }
        if (a.tieneHijos()){
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();

            while(!hijos.fin()){
                numerosImparesMayoresQuePreOrden(hijos.proximo(), n, listaNros);
            }
        }

        int datoActual = a.getDato();
        if (datoActual % 2 != 0 && datoActual > n){
            listaNros.agregarFinal(datoActual);
        }

        return listaNros;
    }

    ///POR NIVELES (NO esta hecho)
    private ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> listaNros){
        //caso base recorre hasta encontrar un arbol nulo y que no tenga hijos
        if (a.esVacio()){
            return listaNros;
        }

        ColaGenerica<ArbolGeneral<Integer>> colaArboles = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        colaArboles.encolar(a);

        while(!colaArboles.esVacia()){

            ArbolGeneral<Integer> actual = colaArboles.tope();
            colaArboles.desencolar();

            int datoActual = a.getDato();
            if (datoActual % 2 != 0 && datoActual > n){
                listaNros.agregarFinal(datoActual);
            }

            if (actual.tieneHijos()){

                ListaGenerica<ArbolGeneral<Integer>> hijos = actual.getHijos();
                hijos.comenzar();
                while(!hijos.fin()){
                    colaArboles.encolar(hijos.proximo());
                }
            }

        }


        return listaNros;

    }

}
