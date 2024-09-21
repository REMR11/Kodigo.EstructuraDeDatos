package binarysearch;

/**
 * Clase para realizar búsqueda binaria en un arreglo.
 */
public class BinarySearcher {
    /**
     * Realiza búsqueda binaria en un arreglo.
     *
     * @param arr    arreglo en el que se realizará la búsqueda
     * @param target valor a buscar en el arreglo
     * @return índice del valor encontrado, o -1 si no se encuentra
     */
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
