package wyszukiwanie;

public class JumpSearch {

    /**
     * Wyszukiwanie skokowe (Jump Search)
     * <p>
     * Przeszukuje posortowaną tablicę, przeskakując określoną liczbę elementów.
     * Po znalezieniu przedziału, w którym może znajdować się szukana wartość,
     * przeszukuje ten przedział liniowo.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(1)</li>
     *     <li>Złożoność pesymistyczna: O(sqrt(n)) => zakładając optymalną wartość parametru k</li>
     *     <li>Złożoność przeciętna: O(sqrt(n)) => jw.</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr posortowana niemalejąco tablica liczb całkowitych
     * @param key szukana wartość
     * @param k   długość skoku
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key, int k) {
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            return -1;
        }

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
        System.out.println(search(arr, 20, 3));
    }
}
