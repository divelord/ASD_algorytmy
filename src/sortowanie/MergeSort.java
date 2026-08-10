package sortowanie;

import java.util.Arrays;

public class MergeSort {

    /**
     * Sortowanie przez scalanie (Merge Sort)
     * <p>
     * Algorytm typu "dziel i rządź". Dzieli ciąg na dwie połowy,
     * rekurencyjnie sortuje każdą z nich, a następnie scala
     * posortowane połówki w jedną całość za pomocą funkcji merge.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(n log n)</li>
     *     <li>Złożoność pesymistyczna: O(n log n)</li>
     *     <li>Złożoność przeciętna: O(n log n)</li>
     *     <li>Złożoność pamięciowa: O(n)</li>
     * </ul>
     * <p>
     * Stabilny: tak
     *
     * @param arr tablica liczb całkowitych
     */

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int middle = arr.length / 2;

        int[] arrLeft = new int[middle];
        int[] arrRight = new int[arr.length - middle];

        System.arraycopy(arr, 0, arrLeft, 0, arrLeft.length);
        System.arraycopy(arr, middle, arrRight, 0, arrRight.length);

        sort(arrLeft);
        sort(arrRight);

        merge(arr, arrLeft, arrRight);
    }

    /**
     * Funkcja pomocnicza scalająca dwa posortowane ciągi w jedną posortowaną tablicę
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(n)</li>
     *     <li>Złożoność przeciętna: O(n)</li>
     *     <li>Złożoność pesymistyczna: O(n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr      tablica docelowa
     * @param arrLeft  lewy posortowany podciąg
     * @param arrRight prawy posortowany podciąg
     */

    private static void merge(int[] arr, int[] arrLeft, int[] arrRight) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arrLeft.length && j < arrRight.length) {
            if (arrLeft[i] <= arrRight[j]) {
                arr[k++] = arrLeft[i++];
            } else {
                arr[k++] = arrRight[j++];
            }
        }

        while (i < arrLeft.length) {
            arr[k++] = arrLeft[i++];
        }

        while (j < arrRight.length) {
            arr[k++] = arrRight[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 42, 53, 522, 51, 72, 93, 23, 1345, 315, 6135};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
