package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Valor encontrado en el índice " + result);
        } else {
            System.out.println("Valor no encontrado");
        }
    }

    /**
     * Realiza la búsqueda binaria en un arreglo ordenado.
     *
     * @param arr    Arreglo ordenado en el que se realizará la búsqueda.
     * @param target Valor que se busca en el arreglo.
     * @return Índice del valor buscado si se encuentra, -1 en caso contrario.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0; // Índice izquierdo del rango de búsqueda
        int right = arr.length - 1; // Índice derecho del rango de búsqueda

        while (left <= right) {
            int mid = left + (right - left) / 2; // Índice medio del rango de búsqueda

            // Comparamos el valor del arreglo en el índice medio con el valor buscado
            if (arr[mid] == target) {
                return mid; // Valor encontrado, devuelve el índice
            } else if (arr[mid] < target) {
                left = mid + 1; // Valor buscado es mayor, ajustamos el rango de búsqueda a la mitad derecha
            } else {
                right = mid - 1; // Valor buscado es menor, ajustamos el rango de búsqueda a la mitad izquierda
            }
        }
        return -1; // Valor no encontrado
    }


}
