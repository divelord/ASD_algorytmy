package wyszukiwanie;

public class Quickselect {

    /**
     * Algorytm Hoare'a (quickselect) do wyszukiwania k-tego najmniejszego elementu w tablicy
     * <p>
     * Tablica jest dzielona na dwie części za pomocą partycjonowania. Po każdym podziale
     * sprawdza, w której części znajduje się szukany element i kontynuuje działanie
     * na tym fragmencie tablicy.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(n)</li>
     *     <li>Złożoność pesymistyczna: O(n^2)</li>
     *     <li>Złożoność przeciętna: O(n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr tablica liczb całkowitych
     * @param k   pozycja szukanego elementu
     * @return wartość k-tego najmniejszego elementu w tablicy
     * @throws IllegalArgumentException w przypadku gdy tablica wynosi null, jest pusta
     *                                  lub wartość k jest nieprawidłowa
     */

    private static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Pusta tablica lub nieprawidłowa wartość k");
        }

        return quickselect(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * Algorytm Hoare'a (quickselect) - pomocnicza metoda rekurencyjna
     *
     * @param arr        tablica liczb całkowitych
     * @param leftIndex  początkowy indeks przeszukiwanego fragmentu tablicy
     * @param rightIndex końcowy indeks przeszukiwanego fragmentu tablicy
     * @param k          indeks (tablicowy) szukanego elementu
     * @return wartość szukanego k-tego najmniejszego elementu
     */

    private static int quickselect(int[] arr, int leftIndex, int rightIndex, int k) {
        if (leftIndex == rightIndex) {
            return arr[leftIndex];
        }

        int pivotIndex = partition(arr, leftIndex, rightIndex);

        if (pivotIndex == k) {
            return arr[k];
        } else if (pivotIndex > k) {
            return quickselect(arr, leftIndex, pivotIndex - 1, k);
        } else {
            return quickselect(arr, pivotIndex + 1, rightIndex, k);
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
        int[] arr = {12, 543, 23, 53, 354, 325, 4, 653, 345};

        System.out.println(kthSmallest(arr, 4));
    }
}
