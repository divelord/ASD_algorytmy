package rekurencja;

public class RecursiveMinSearch {

    /**
     * Rekurencyjne wyszukiwanie minimum
     * <p>
     * Algorytm opiera się na strategii "dziel i rządź". Dzieli tablicę na dwie połowy,
     * rekurencyjnie znajduje minimum w lewej oraz prawej części, a następnie zwraca
     * mniejszą z tych dwóch wartości.
     * <p>
     * <ul>
     *     <li>Złożoność czasowa: O(n)</li>
     *     <li>Złożoność pamięciowa: O(log n)</li>
     * </ul>
     *
     * @param arr tablica liczb całkowitych
     * @return minimalna wartość w tablicy
     * @throws IllegalArgumentException jeśli tablica jest pusta lub null
     */

    private static int search(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Pusta tablica");
        }

        return search(arr, 0, arr.length - 1);
    }

    /**
     * Pomocnicza metoda rekurencyjna wyszukująca minimum w podanym ciągu
     *
     * @param arr        tablica liczb całkowitych
     * @param leftIndex  początkowy indeks przeszukiwanego fragmentu
     * @param rightIndex końcowy indeks przeszukiwanego fragmentu
     * @return wartość w podanym zakresie
     */

    private static int search(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return arr[leftIndex];
        }

        int middle = (leftIndex + rightIndex) / 2;

        int minLeft = search(arr, leftIndex, middle);
        int minRight = search(arr, middle + 1, rightIndex);

        return Math.min(minLeft, minRight);
    }

    public static void main(String[] args) {
        int[] arr = {13, 342, 42, 41, 3, 421, 34, 52, 74, 135, 245};
        System.out.println(search(arr));
    }
}
