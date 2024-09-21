package insertsort;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = {12, 23, 32, 45, 32, 21, 43, 78, 9, 87};

        insertSort(arr);

        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void insertSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int key = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }
}
