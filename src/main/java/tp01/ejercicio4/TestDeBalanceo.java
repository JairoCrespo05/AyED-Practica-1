package tp01.ejercicio4;

import tp01.ejercicio3.PilaGenerica;

public class TestDeBalanceo {
    private PilaGenerica<Character> pila;

    public TestDeBalanceo(PilaGenerica<Character> pila) {
        this.pila = pila;
    }

    public boolean esBalanceado(String s){
        boolean balanceado = false;

        //Caso base donde si el string esta vacio y la pila tambien entonces devuelve true
        // (para evitar errores como --> "(((" = true)
        if(s.isEmpty()){
            return (this.pila.esVacia());
        }

        if( '(' == s.charAt(0) || '{' == s.charAt(0) || '[' == s.charAt(0) ) {
            this.pila.apilar(s.charAt(0));
            balanceado = esBalanceado(s.substring(1));

        }else if ( ')' == s.charAt(0) || '}' == s.charAt(0) || ']' == s.charAt(0) ){
            //si la pila esta vacia las llaves no estan cerradas
            if(this.pila.esVacia()){
                return false;
            }
            if(!coinciden(this.pila.tope(), s.charAt(0))){
                return false;

            }

            this.pila.desapilar();
            balanceado = esBalanceado(s.substring(1));
        }

        return balanceado;
    }


    private boolean coinciden(Character apertura, Character cierre){
        return apertura.equals('(') && cierre.equals(')') ||
                apertura.equals('[') && cierre.equals(']') ||
                apertura.equals('{') && cierre.equals('}');
    }

}
