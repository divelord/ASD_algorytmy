package sortowanie;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Sortowanie przez wstawianie (Insertion Sort)
     * <p>
     * Począwszy od drugiej pozycji, bieżący element porównujemy z elementami
     * znajdującymi się wcześniej i przesuwamy większe elementy w prawo,
     * aż znajdziemy dla niego właściwą pozycję.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(n)</li>
     *     <li>Złożoność pesymistyczna: O(n^2)</li>
     *     <li>Złożoność przeciętna: O(n^2)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
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

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {123, 24, 1, 43, 534, 56, 345};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
