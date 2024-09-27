package selectsort;

import java.util.Scanner;

/**
 * Clase que contiene el método main y el algoritmo de selección para ordenar un arreglo de enteros.
 *
 * @author REMR11
 */
public class SelectSort {

    /**
     * Punto de entrada del programa.
     */
    public static void initSelectSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un conjunto de números separados por comas: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(","); // Separa la entrada en un arreglo de strings
        int[] listaNumeros = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            listaNumeros[i] = Integer.parseInt(numbers[i]); // Convierte cada string en un entero
        }

        int[] result = SelectSort(listaNumeros); // Ordena el arreglo utilizando el algoritmo de selección

        System.out.println("Arreglo ordenado:");
        for (int i : result) {
            System.out.println(i); // Imprime el arreglo ordenado
        }
    }

    /**
     * Método que implementa el algoritmo de selección para ordenar un arreglo de enteros.
     *
     * @param listaNumeros Arreglo de enteros a ordenar
     * @return Arreglo ordenado
     */
    private static int[] SelectSort(int[] listaNumeros) {
        int lista = listaNumeros.length;

        for (int i = 0; i < lista; i++) {
            int minIndex = i; // Índice del elemento mínimo en el rango de búsqueda

            for (int j = i + 1; j < lista; j++) {
                if (listaNumeros[j] < listaNumeros[minIndex]) {
                    minIndex = j; // Actualiza el índice del elemento mínimo
                }
            }

            // Intercambia el elemento actual con el elemento mínimo
            int temp = listaNumeros[i];
            listaNumeros[i] = listaNumeros[minIndex];
            listaNumeros[minIndex] = temp;
        }

        return listaNumeros;
    }
}