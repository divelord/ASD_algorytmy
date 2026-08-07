package wyszukiwanie;

public class BinarySearch {

    /**
     * Algorytm wyszukiwania binarnego
     *
     * @param arr posortowana niemalejąco tablica liczb całkowitych
     * @param key szukana wartość
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key) {
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
