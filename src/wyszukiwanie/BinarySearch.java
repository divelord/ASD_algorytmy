package wyszukiwanie;

public class BinarySearch {

    /**
     * Wyszukiwanie binarne (Binary Search)
     * <p>
     * Przeszukuje posortowaną tablicę, dzieląc ją na pół w każdym kroku.
     * Porównuje środkowy element z szukaną wartością i na tej podstawie
     * odrzuca połowę tablicy, w której element nie może się znajdować.
     * Algorytm powtarza ten proces, aż znajdzie szukaną wartość lub wyczerpie
     * zakres poszukiwań.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(1)</li>
     *     <li>Złożoność pesymistyczna: O(log n)</li>
     *     <li>Złożoność przeciętna: O(log n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr posortowana niemalejąco tablica liczb całkowitych
     * @param key szukana wartość
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == key) {
                return middle;
            } else {
                if (arr[middle] > key) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 9, 23, 45};

        System.out.println(search(arr, 23));
        System.out.println(search(arr, 11));
    }
}
