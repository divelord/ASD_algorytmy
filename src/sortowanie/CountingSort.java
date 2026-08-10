package sortowanie;

import java.util.Arrays;

public class CountingSort {

    /**
     * Sortowanie przez zliczanie (Counting Sort)
     * <p>
     * Algorytm sortowania dedykowany dla ciągu liczb całkowitych. Wykorzystuje tzw.
     * adresowanie bezpośrednie z uwzględnieniem przesunięcia wyznaczonego poprzez wartość minimalną.
     * Umieszcza elementy ciągu wejściowego bezpośrednio w wynikowej tablicy na podstawie ich wartości,
     * bez porównywania ich między sobą. Aby proces przebiegał efektywnie, dane muszą mieścić się
     * w pamięci o dostępie swobodnym (RAM)
     * <p>
     * Złożoność optymistyczna: O(n + k) => gdzie k = maxVal - minVal + 1
     * Złożoność pesymistyczna: O(n + k) => jw.
     * Złożoność przeciętna: O(n + k) => jw.
     * Złożoność pamięciowa: O(n + k) => jw.
     * <p>
     * Stabilny: tak
     *
     * @param arr tablica liczb całkowitych
     * @return posortowana tablica liczb całkowitych
     */

    private static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int minVal = arr[0];
        int maxVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        int range = maxVal - minVal + 1;
        int[] counts = new int[range];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] - minVal]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = result.length - 1; i >= 0; i--) {
            result[--counts[arr[i] - minVal]] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-3, 3, 2, 5, -2, 1, 2, 6, 8, 1, 2, -1, 4};
        int[] arrSorted = sort(arr);

        System.out.println(Arrays.toString(arrSorted));
    }
}
