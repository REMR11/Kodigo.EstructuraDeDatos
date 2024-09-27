package bubble;

import java.util.Scanner;

public class Bubble {
    public static void initBubble(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de números que quiere ingresar
        System.out.print("¿Cuántos números deseas ingresar?: ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];

        // Solicitar al usuario que ingrese los números
        System.out.println("Introduce " + n + " números:");
        for (int i = 0; i < n; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Imprimir los números antes de ordenar para verificar la entrada
        System.out.println("Números ingresados:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Aplicar el algoritmo de ordenamiento burbuja
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiar los elementos
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Mostrar los números ordenados
        System.out.println("Números ordenados:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}

/*

    * Salida del programa:

    ¿Cuántos números deseas ingresar?: 5
    Introduce 5 números:
    Número 1: 21
    Número 2: 13
    Número 3: 28
    Número 4: 18
    Número 5: 12
    Números ingresados:
    21 13 28 18 12 
    Números ordenados:
    12 13 18 21 28 

 */