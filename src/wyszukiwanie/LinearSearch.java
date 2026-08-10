package wyszukiwanie;

public class LinearSearch {

    /**
     * Wyszukiwanie liniowe (Linear Search) w ciągu nieuporządkowanym
     * <p>
     * Przegląda elementy tablicy po kolei od początku do końca,
     * porównując każdy z nich z poszukiwaną wartością.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(1)</li>
     *     <li>Złożoność pesymistyczna: O(n)</li>
     *     <li>Złożoność przeciętna: O(n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr tablica liczb całkowitych
     * @param key szukana wartość
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == key) {
                return index;
            }
        }

        return -1;
    }

    /**
     * Wyszukiwanie liniowe (Linear Search) w ciągu posortowanym
     * <p>
     * Przegląda elementy tablicy po kolei, ale w posortowanej tablicy
     * pozwala na wcześniejsze przerwanie algorytmu w momencie napotkania
     * elementu większego od szukanej wartości.
     * <p>
     * <ul>
     *     <li>Złożoność optymistyczna: O(1)</li>
     *     <li>Złożoność pesymistyczna: O(n)</li>
     *     <li>Złożoność przeciętna: O(n)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param arr posortowana niemalejąco tablica liczb całkowitych
     * @param key szukana wartość
     * @return indeks znalezionego elementu lub -1, jeśli element nie występuje w tablicy
     */

    private static int searchSorted(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == key) {
                return index;
            }

            if (arr[index] > key) {
                return -1;
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
