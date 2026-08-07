package wyszukiwanie;

public class Quickselect {

    /**
     * Algorytm Hoare'a (quickselect) do wyszukiwania k-tego najmniejszego elementu w tablicy
     *
     * @param arr tablica liczb całkowitych
     * @param k   pozycja szukanego elementu
     * @return wartość k-tego najmniejszego elementu w tablicy
     * @throws IllegalStateException jeśli algorytm zakończy działanie bez znalezienia elementu
     */

    private static int kthSmallest(int[] arr, int k) {
        k--; // dopasowanie k-tego elementu do indeksowania tablicy

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex <= rightIndex) {
            int i = partition(arr, leftIndex, rightIndex);

            if (i == k) {
                return arr[k];
            } else if (i > k) {
                rightIndex = i - 1;
            } else {
                leftIndex = i + 1;
            }
        }

        throw new IllegalStateException("Nie znaleziono k-tego najmniejszego elementu");
    }

    /**
     * Algorytm pomocniczy partition
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

        while (true) {
            while (i <= rightIndex && arr[i] <= pivot) {
                i++;
            }
            while (j >= leftIndex && arr[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        int tmp = arr[leftIndex];
        arr[leftIndex] = arr[j];
        arr[j] = tmp;

        return j;
    }

    public static void main(String[] args) {
        int[] arr = {12, 543, 23, 53, 354, 325, 4, 653, 345};

        System.out.println(kthSmallest(arr, 4));
    }
}
