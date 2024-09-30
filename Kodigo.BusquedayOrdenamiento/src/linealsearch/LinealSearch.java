package linealsearch;

import java.util.Scanner;

public class LinealSearch {
    public static void InitLinealSearch() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa un conjunto de numeros separados por comas: ");
            String input = scanner.nextLine();
            String[] numbers = input.split(",");
            int[] array = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i].trim());
            }

            System.out.print("Ingresa un numero para buscar: ");
            int target = scanner.nextInt();

            int result = linearSearch(array, target);
            if (result != -1) {
                System.out.println("Elemento encontrado en el indice: " + result);
            } else {
                System.out.println("Elemento no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
