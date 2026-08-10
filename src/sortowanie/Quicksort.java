package sortowanie;

import java.util.Arrays;

public class Quicksort {

    /**
     * Sortowanie szybkie (Quicksort) - główna metoda
     * <p>
     * Algorytm rekurencyjny działający na zasadzie "dziel i zwyciężaj". W każdym kroku
     * wybiera pivot i za pomocą metody partition dzieli tablicę na dwie podtablice.
     * Następnie rekurencyjnie sortuje obie części niezależnie.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(n log n)</li>
     *     <li>Złożoność pesymistyczna: O(n^2)</li>
     *     <li>Złożoność przeciętna: O(n log n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     * <p>
     * Stabilny: nie
     *
     * @param arr tablica liczb całkowitych
     */

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    /**
     * Sortowanie szybkie (Quicksort) - pomocnicza metoda rekurencyjna
     *
     * @param arr        tablica liczb całkowitych
     * @param leftIndex  początkowy indeks przeszukiwanego fragmentu tablicy
     * @param rightIndex końcowy indeks przeszukiwanego fragmentu tablicy
     */

    private static void sort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = partition(arr, leftIndex, rightIndex);
            sort(arr, leftIndex, pivotIndex - 1);
            sort(arr, pivotIndex + 1, rightIndex);
        }
    }

    /**
     * Metoda pomocnicza partition
     * <p>
     * Przestawia elementy podtablicy tak, że elementy na lewo od pivota są niewiększe,
     * a na prawo niemniejsze.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(n)</li>
     *     <li>Złożoność pesymistyczna: O(n)</li>
     *     <li>Złożoność przeciętna: O(n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr        tablica liczb całkowitych
     * @param leftIndex  początkowy indeks przeszukiwanego fragmentu tablicy
     * @param rightIndex końcowy indeks przeszukiwanego fragmentu tablicy
     * @return indeks elementu, na którym znajduje się pivot po zakończeniu partycjonowania
     */

    private static int partition(int[] arr, int leftIndex, int rightIndex) {
        int pivot = arr[leftIndex];
        int i = leftIndex + 1;
        int j = rightIndex;

        do {
            while (i < rightIndex && arr[i] <= pivot) {
                i++;
            }
            while (j > i && arr[j] >= pivot) {
                j--;
            }

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        } while (i < j);

        if (arr[i] > pivot) {
            arr[leftIndex] = arr[i - 1];
            arr[i - 1] = pivot;

            return i - 1;
        } else {
            arr[leftIndex] = arr[i];
            arr[i] = pivot;

            return i;
        }
    }

    public static void main(String[] args) {
        int[] arr = {27, 7, 51, 21, 9, 91, 56, 16, 79, 48};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

