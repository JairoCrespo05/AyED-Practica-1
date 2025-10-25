package tp05;

public class TestHeap {
    public static void main(String[] args) {
        var heap = new MinHeap<Integer>();
//        var heap = new MaxHeap<Integer>();
//        15, 25, 23, 13, 18, 2, 19, 20, 17

        heap.agregar(15);

        heap.agregar(25);

        heap.agregar(23);

        heap.agregar(13);

        heap.agregar(18);

        heap.agregar(2);

        heap.agregar(19);

        heap.agregar(20);

        heap.agregar(17);


        System.out.println("/////////////////ANTES DE ELIMINAR///////////");

        System.out.println("El tope es:"+heap.tope());

        heap.imprimir();

        System.out.println("/////////////////DESPUES DE ELIMINAR///////////");

        heap.eliminar();

        System.out.println("El tope es:"+heap.tope());

        heap.imprimir();
    }
}
