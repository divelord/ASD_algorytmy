package rekurencja;

public class TowerOfHanoi {

    /**
     * Minimalna liczba ruchów do rozwiązania Wieży Hanoi
     * <p>
     * Algorytm opiera się na strategii "dziel i rządź". Aby przenieść n krążków
     * z drążka początkowego na docelowy, należy najpierw przenieść n-1 krążków
     * na drążek pomocniczy, następnie przenieść największy krążek na drążek
     * docelowy, a na końcu przenieść n-1 krążków z drążka pomocniczego
     * na drążek docelowy.
     * <p>
     * <ul>
     *     <li>Złożoność czasowa: O(n)</li>
     *     <li>Złożoność pamięciowa: O(n)</li>
     * </ul>
     *
     * @param n liczba krążków
     * @return minimalna liczba ruchów potrzebna do przeniesienia krążków
     */

    private static int hanoi(int n) {
        if (n == 1) {
            return 1;
        }

        return 2 * hanoi(n - 1) + 1;
    }

    /**
     * Metoda wypisująca minimalną liczbę ruchów do rozwiązania Wieży Hanoi
     * <p>
     * <ul>
     *     <li>Złożoność czasowa: O(2^n)</li>
     *     <li>Złożoność pamięciowa: O(n)</li>
     * </ul>
     *
     * @param n       liczba krążków
     * @param fromRod drążek początkowy
     * @param auxRod  drążek pomocniczy
     * @param toRod   drążek docelowy
     */

    private static void towerOfHanoi(int n, char fromRod, char auxRod, char toRod) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, fromRod, toRod, auxRod);

        System.out.println("Przeniesiono krążek " + n + " z drążka " + fromRod + " na drążek " + toRod);

        towerOfHanoi(n - 1, auxRod, fromRod, toRod);
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println(hanoi(n));
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}
