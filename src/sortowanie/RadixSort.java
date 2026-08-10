package sortowanie;

import java.util.Arrays;

public class RadixSort {

    /**
     * Sortowanie pozycyjne (Radix Sort)
     * <p>
     * Algorytm sortowania dedykowany dla ciągu liczb naturalnych. Nie porównuje elementów
     * między sobą, lecz sortuje je po kolejnych pozycjach cyfr: od najmniej znaczącej (ostatniej)
     * do najbardziej znaczącej (pierwszej), wykorzystując przy każdym przejściu stabilne sortowanie
     * przez zliczanie jako procedurę pomocniczą.
     * <p>
     * Złożoność optymistyczna: O(d * (n + k)) => gdzie d = liczba cyfr maxVal, k = 10 (cyfry 0..9)
     * Złożoność pesymistyczna: O(d * (n + k)) => jw.
     * Złożoność przeciętna: O(d * (n + k)) => jw.
     * Złożoność pamięciowa: O(n + k) => jw.
     * <p>
     * Stabilny: tak
     *
     * @param arr tablica liczb naturalnych
     */

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int maxVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * Metoda pomocnicza oparta na Counting Sort
     *
     * @param arr tablica liczb naturalnych
     * @param exp wskaźnik pozycyjny cyfry
     */

    private static void countingSort(int[] arr, int exp) {
        int[] counts = new int[10];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / exp) % 10;
            counts[digit]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = result.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            result[--counts[digit]] = arr[i];
        }

        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {212, 305, 115, 202, 131};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
