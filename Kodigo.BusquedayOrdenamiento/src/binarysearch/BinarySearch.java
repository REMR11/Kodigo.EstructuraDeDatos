package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void initBinarySearch(String[] args) {
        InputReader inputReader = new InputReader();
        int[] arr = inputReader.readArrayFromConsole();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + "-" + arr[i]);
        }

        int target = inputReader.readIntFromConsole("Ingrese un número para buscar: ");

        BinarySearcher binarySearcher = new BinarySearcher();
        int result = binarySearcher.search(arr, target);

        if (result != -1) {
            System.out.println("Valor encontrado en el índice " + (result + 1));
        } else {
            System.out.println("Valor no encontrado");
        }
    }
}
