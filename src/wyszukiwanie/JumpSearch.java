package wyszukiwanie;

public class JumpSearch {

    /**
     * Algorytm wyszukiwania skokowego
     *
     * @param arr posortowana niemalejąco tablica liczb całkowitych
     * @param key szukana wartość
     * @param k   długość skoku
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key, int k) {
        int i = 0;

        while (i < arr.length && arr[i] < key) {
            i += k;
        }

        int start = Math.max(0, i - k + 1);
        int end = Math.min(i, arr.length - 1);

        for (int j = start; j <= end; j++) {
            if (arr[j] == key) {
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 9, 23, 45};

        System.out.println(search(arr, 7, 3));
        System.out.println(search(arr, 2, 3));
    }
}
