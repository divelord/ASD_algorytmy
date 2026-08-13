package rekurencja;

public class RecursiveBinarySearch {

    /**
     * Rekurencyjne wyszukiwanie binarne (Binary Search)
     * <p>
     * Algorytm opiera się na strategii "dziel i rządź". Przeszukuje posortowaną
     * tablicę, dzieląc ją na pół w każdym kroku. Porównuje środkowy element
     * z szukaną wartością i na tej podstawie odrzuca połowę tablicy, wywołując się
     * rekurencyjnie dla wybranej części.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(1)</li>
     *     <li>Złożoność pesymistyczna: O(log n)</li>
     *     <li>Złożoność przeciętna: O(log n)</li>
     *     <li>Złożoność pamięciowa: O(log n)</li>
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

        return search(arr, key, 0, arr.length - 1);
    }

    /**
     * Pomocnicza metoda rekurencyjna dla wyszukiwania binarnego
     *
     * @param arr        posortowana niemalejąco tablica liczb całkowitych
     * @param key        szukana wartość
     * @param leftIndex  początkowy indeks przeszukiwanego fragmentu tablicy
     * @param rightIndex końcowy indeks przeszukiwanego fragmentu tablicy
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return -1;
        }

        int middle = (leftIndex + rightIndex) / 2;

        if (arr[middle] == key) {
            return middle;
        }

        if (arr[middle] > key) {
            return search(arr, key, leftIndex, middle - 1);
        } else {
            return search(arr, key, middle + 1, rightIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 9, 23, 45};

        System.out.println(search(arr, 23));
        System.out.println(search(arr, 11));
    }
}
