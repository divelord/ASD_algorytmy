package wyszukiwanie;

public class LinearSearch {

    /**
     * Algorytm wyszukiwania liniowego w ciągu nieuporządkowanym
     *
     * @param arr tablica liczb całkowitych
     * @param key szukana wartość
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == key) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Algorytm wyszukiwania liniowego w ciągu posortowanym niemalejąco
     *
     * @param arr posortowana niemalejąco tablica liczb całkowitych
     * @param key szukana wartość
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int searchSorted(int[] arr, int key) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] > key) {
                return -1;
            }
            if (arr[index] == key) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 2, 1, 8, 4, 2, 9};

        System.out.println(search(arr, 2));
        System.out.println(search(arr, 7));

        int[] arrSorted = {1, 2, 3, 5, 6, 7, 8};

        System.out.println(searchSorted(arrSorted, 3));
        System.out.println(searchSorted(arrSorted, 4));
    }
}
