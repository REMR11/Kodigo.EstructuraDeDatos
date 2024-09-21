package binarysearch;

import java.util.Scanner;

/**
 * Clase para leer entrada del usuario.
 */
public class InputReader {
    private Scanner scanner;

    /**
     * Constructor de la clase InputReader.
     */
    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lee un arreglo de enteros desde la consola.
     *
     * @return arreglo de enteros leído desde la consola
     */
    public int[] readArrayFromConsole() {
        System.out.print("Ingrese un conjunto de números separados por comas: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(",");
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        return arr;
    }

    /**
     * Lee un entero desde la consola.
     *
     * @param prompt mensaje para solicitar la entrada del usuario
     * @return entero leído desde la consola
     */
    public int readIntFromConsole(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}