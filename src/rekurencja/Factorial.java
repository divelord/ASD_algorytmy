package rekurencja;

public class Factorial {

    /**
     * Obliczanie silni
     * <p>
     * Metoda oblicza iloczyn wszystkich dodatnich liczb naturalnych
     * niewiększych od n.
     * <p>
     * <ul>
     *     <li>Złożoność czasowa: O(n)</li>
     *     <li>Złożoność pamięciowa: O(n)</li>
     * </ul>
     *
     * @param n liczba naturalna, dla której ma być obliczona silnia
     * @return wartość silni z n
     */

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 6; i++) {
            System.out.println(factorial(i));
        }
    }
}
