package rekurencja;

public class Fibonacci {

    /**
     * Obliczanie n-tego wyrazu ciągu Fibonacciego
     * <p>
     * Metoda oblicza n-tą liczbę ciągu Fibonacciego.
     * <p>
     * <ul>
     *     <li>Złożoność czasowa: O(2^n)</li>
     *     <li>Złożoność pamięciowa: O(n)</li>
     * </ul>
     *
     * @param n numer wyrazu do wyznaczenia
     * @return wartość n-tego wyrazu
     */

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Obliczanie n-tego wyrazu ciągu Fibonacciego za pomocą wzoru Bineta
     * <p>
     * Metoda wykorzystuje bezpośredni wzór oparty na równaniu charakterystycznym:
     * <b>x^2 - ax - b = 0</b>.
     * <p>
     * <ul>
     *     <li>Złożoność czasowa: O(1)</li>
     *     <li>Złożoność pamięciowa: O(1)</li>
     * </ul>
     *
     * @param n numer wyrazu do wyznaczenia
     * @return wartość n-tego wyrazu
     */

    private static long fibonacciBinetFormula(int n) {
        double sqrt = Math.sqrt(5);
        double a = (1 + sqrt) / 2;
        double b = (1 - sqrt) / 2;
        double result = (Math.pow(a, n) - Math.pow(b, n)) / sqrt;

        return Math.round(result);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(fibonacci(i));
        }

        System.out.println(fibonacciBinetFormula(50));
    }
}
