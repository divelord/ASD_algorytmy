package wyszukiwanie;

import java.util.ArrayList;
import java.util.List;

public class TournamentSearch {

    /**
     * Pomocnicza klasa reprezentująca węzeł w drzewie turniejowym
     */

    private static class Node {
        int value;
        List<Integer> defeated = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Algorytm wyszukiwania turniejowego znajdujący drugą najmniejszą wartość
     *
     * @param arr tablica liczb całkowitych
     * @return druga najmniejsza wartość w tablicy
     */

    private static int search(int[] arr) {
        List<Node> currentRound = new ArrayList<>();

        for (int val : arr) {
            currentRound.add(new Node(val));
        }

        while (currentRound.size() > 1) {
            List<Node> nextRound = new ArrayList<>();

            for (int i = 0; i < currentRound.size(); i += 2) {
                if (currentRound.size() > i + 1) {
                    Node valA = currentRound.get(i);
                    Node valB = currentRound.get(i + 1);

                    if (valA.value < valB.value) {
                        valA.defeated.add(valB.value);
                        nextRound.add(valA);
                    } else {
                        valB.defeated.add(valA.value);
                        nextRound.add(valB);
                    }
                } else {
                    nextRound.add(currentRound.get(i));
                }
            }

            currentRound = nextRound;
        }

        Node minVal = currentRound.getFirst();
        int secondMinVal = Integer.MAX_VALUE;

        for (int val : minVal.defeated) {
            if (val < secondMinVal) {
                secondMinVal = val;
            }
        }

        return secondMinVal;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 20, 5, 30, 4, 40, 1};

        System.out.println(search(arr));
    }
}
