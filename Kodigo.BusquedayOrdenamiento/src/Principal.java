public class Principal {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        // Insertar elementos
        lista.insertarAlInicio(10);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(30);

        /*Imprimir la lista*/
        System.out.println("Lista enlazada después de insertar elementos:");
        lista.imprimirLista();

        /*Eliminar elemento al inicio*/
        lista.eliminarAlInicio();
        System.out.println("Lista enlazada después de eliminar el primer elemento:");
        lista.imprimirLista();
    }
}
