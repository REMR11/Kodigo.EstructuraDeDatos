package selectsort;

/**
 * Clase principal que contiene el método main y el algoritmo de selección.
 *
 * @author REMR11
 */
public class main {
    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        int[] listaNumeros = {5, 4, 2, 6, 7, 3, 12, 223, 456, 34, 1};

        int[] Result = SelectSort(listaNumeros);

        for (int i : Result) {
            System.out.println(i);
        }
    }

    /**
     * Método que implementa el algoritmo de selección para ordenar un arreglo de enteros.
     *
     * @param listaNumeros arreglo de enteros a ordenar
     * @return arreglo ordenado
     */
    private static int[] SelectSort(int[] listaNumeros) {
        int lista = listaNumeros.length;

        for (int i = 0; i < lista; i++) {

            int minIndex = i;

            for (int j = i + 1; j < lista; j++) {

                if (listaNumeros[j] < listaNumeros[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = listaNumeros[i];
            listaNumeros[i] = listaNumeros[minIndex];
            listaNumeros[minIndex] = temp;
        }

        return listaNumeros;
    }


}
