package tp01.ejercicio4;

import tp01.ejercicio3.PilaGenerica;

public class TestDeBalanceo {
    private PilaGenerica<Character> pila;

    public TestDeBalanceo(PilaGenerica<Character> pila) {
        this.pila = pila;
    }


    public boolean estaBalanceado(String s){
        boolean confirmado = esBalanceado(s, 0);

        if (!this.pila.esVacia()){
            while (!this.pila.esVacia()){
                this.pila.desapilar();
            }
            confirmado = false;
        }

        return  confirmado;
    }

    private boolean esBalanceado(String s, int index){

        //Caso base donde si el string esta vacio y la pila tambien entonces devuelve true
        // (para evitar errores como --> "(((" = true)
        if(index == s.length()){
            return true;
        }

        char letra = s.charAt(index);

        if (letra == ' '){
            return esBalanceado(s, index + 1);
        }

        if( '(' == letra || '{' == letra || '[' == letra ) {
            this.pila.apilar(letra);

        }else if ( ')' == letra || '}' == letra || ']' == letra ){
            //si la pila esta vacia las llaves no estan abiertas
            if(this.pila.esVacia()){
                return false;
            }
            //si no coinciden no tiene caso seguir la recursion
            if(!coinciden(this.pila.tope(), letra)){
                return false;
            }

            this.pila.desapilar();
        }else {
            return false;
        }


        return esBalanceado(s, index + 1);
    }


    private boolean coinciden(Character apertura, Character cierre){
        return apertura.equals('(') && cierre.equals(')') ||
                apertura.equals('[') && cierre.equals(']') ||
                apertura.equals('{') && cierre.equals('}');
    }

}
