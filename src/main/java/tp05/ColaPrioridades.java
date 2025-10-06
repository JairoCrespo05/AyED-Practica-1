package tp05;

public interface ColaPrioridades <T>{

    boolean esVacia();

    void eliminar();

    boolean agregar(T elemento);

    T tope();

}
