package tp02.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {

    public AnalizadorArbol(){

    }

    public Double devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol){
            Double maxPromedio = 0.0;
            int sumaNros = 0;

        //caso base recorre hasta encontrar un arbol nulo y que no tenga hijos
        if (arbol.esVacio()){
            return 0.0;
        }

        ColaGenerica<ArbolGeneral<AreaEmpresa>> colaArboles = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        colaArboles.encolar(arbol);

        while(!colaArboles.esVacia()){

            // en cada ciclo del while se volvera a inicializar el tamanio de la nueva cola
            //la cantidad de nodos por nivel esta comprendido por el tamanio que tiene la cola en este momento de la ejecucion
            int nodosXNivel = colaArboles.tamanio();

            //saco todos los nodos del mismo nivel en un bucle for para asi vaciar la cola pero
            // solo estara completamente vacia en caso de que no exista otro nivel por debajo, si lo hay, se encola
            for(int i=0; i < nodosXNivel; i++){

                //obtengo el nodo actual y sus datos
                ArbolGeneral<AreaEmpresa> actual = colaArboles.tope();
                colaArboles.desencolar();

                //sumos los numeros del mismo nivel
                sumaNros += actual.getDato().MiTardanzaDeTransmision();


                // Si el nodo actual tiene hijos entonces los meto en la cola
                if (actual.tieneHijos()){
                    ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = actual.getHijos();
                    hijos.comenzar();

                    while(!hijos.fin()){
                        colaArboles.encolar(hijos.proximo());
                    }
                }

            }
            //obtengo el promedio actual de este nivel
            double promedioActual = sumaNros / nodosXNivel;

            //si tengo un promedio actual mayor que el promedio maximo, lo sobreescribo con el promedio actual
            if(promedioActual > maxPromedio){
                maxPromedio = promedioActual;
            }

            //vulevo a inicializar la suma de numeros por si existe un nuevo nivel debajo de este nivel actual
            sumaNros = 0;
        }

        return maxPromedio;
    }




}
