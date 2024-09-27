import binarysearch.BinarySearch;
import bubble.Bubble;
import insertsort.InsertSort;
import selectsort.SelectSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Bienvenido al menú de ordenamiento y busqueda");
            System.out.println("=================================");
            System.out.println("Seleccione un algoritmo:");
            System.out.println("1. Selección (Select Sort)");
            System.out.println("2. Inserción (Insert Sort)");
            System.out.println("3. Burbuja (Bubble Sort)");
            System.out.println("4. Lineal (Linear Search)");
            System.out.println("5. Binario (Binary Search)");
            System.out.println("6. Salir");
            System.out.println("=================================");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado el algoritmo de selección");
                    SelectSort selectSort = new SelectSort();
                    selectSort.initSelectSort();
                    break;
                case 2:
                    System.out.println("Has seleccionado el algoritmo de inserción");
                    InsertSort insertSort = new InsertSort();
                    insertSort.initInsertSort();
                    break;
                case 3:
                    System.out.println("Has seleccionado el algoritmo de burbuja");
                    Bubble bubble = new Bubble();
                    bubble.initBubble();
                    break;
                case 4:
                    System.out.println("Has seleccionado el algoritmo lineal");
                    // Llamar al método lineal
                    System.out.println("Muy pronto!");
                    break;
                case 5:
                    System.out.println("Has seleccionado el algoritmo binario");
                    // Llamar al método binario
                    BinarySearch binarySearch = new BinarySearch();
                    binarySearch.initBinarySearch();
                    break;
                case 6:
                    System.out.println("Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}