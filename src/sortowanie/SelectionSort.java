package sortowanie;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Sortowanie przez wybór (Selection Sort)
     * <p>
     * W sortowanym ciągu znajdujemy minimum, zamieniamy je miejscami z pierwszym
     * elementem ciągu i kontynuujemy to samo na ciągu zaczynającym się
     * od drugiego indeksu, dopóki bieżący ciąg ma więcej niż 1 element.
     * <p>
     * Złożoność optymistyczna: O(n^2)
     * Złożoność pesymistyczna: O(n^2)
     * Złożoność przeciętna: O(n^2)
     * Złożoność pamięciowa: O(1)
     * <p>
     * Stabilny: nie
     *
     * @param arr tablica liczb całkowitych
     */

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 435, 142, 13, 15, 4};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
