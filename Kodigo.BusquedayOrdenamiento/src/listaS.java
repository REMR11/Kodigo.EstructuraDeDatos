class ListaEnlazadaSimple {
    private Nodo cabeza;

    /*Constructor que inicializa la cabeza en null*/
    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    /* Metodo para insertar un nodo al inicio*/
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    /* Metodo para eliminar el nodo al inicio*/
    public void eliminarAlInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        } else {
            System.out.println("La lista está vacía, no hay nada que eliminar.");
        }
    }

    /*Metodo para imprimir los elementos de la lista*/
    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
