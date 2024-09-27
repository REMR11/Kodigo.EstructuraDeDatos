package insertsort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que contiene el método main para probar el algoritmo de inserción.
 *
 * @author REMR11
 */
public class InsertSort {

    /**
     * Punto de entrada del programa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso)
     */
    public static void initInsertSort(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un conjunto de números separados por comas: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(","); // Separa la entrada en un arreglo de strings
        int[] listaNumeros = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            listaNumeros[i] = Integer.parseInt(numbers[i]); // Convierte cada string en un entero
        }

        int[] result = insertSort(listaNumeros); // Ordena el arreglo utilizando el algoritmo de selección

        System.out.println("Arreglo ordenado:");
        for (int i : result) {
            System.out.println(i); // Imprime el arreglo ordenado
        }
    }

    /**
     * Ordena un arreglo utilizando el algoritmo de inserción.
     *
     * @param arr Arreglo a ordenar
     */
    private static int[] insertSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int key = arr[i]; // Elemento actual a insertar en su posición correcta

            int j = i - 1; // Índice del elemento anterior
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Desplaza el elemento actual hacia la derecha
                j = j - 1; // Avanza hacia la izquierda en el arreglo
            }
            arr[j + 1] = key; // Inserta el elemento en su posición correcta
        }

        return arr;
    }
}