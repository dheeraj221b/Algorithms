
/**
 * CoinInALineGameProblem
 * 
 * Objective: In this game, which we will call the coins-in-a-line game, an even
 * number, n, of coins, of various denominations from various countries, are
 * placed in a line. Two players, who we will call Alice and Bob, take turns
 * removing one of the coins from either end of the remaining line of coins.
 * That is, when it is a player’s turn, he or she removes the coin at the left
 * or right end of the line of coins and adds that coin to his or her
 * collection. The player who removes a set of coins with larger total value
 * than the other player wins, where we assume that both Alice and Bob know the
 * value of each coin.
 * 
 * coins [] = { 6, 9, 1, 2, 16, 8} ,
 * 
 * Alice picks 6 coins [] = { 9, 1, 2, 16, 8},
 * 
 * Bob picks 9 coins [] = { 1, 2, 16, 8},
 * 
 * Alice picks 1 coins [] = 2, 16, 8},
 * 
 * Bob picks 8 coins [] = {2, 16},
 * 
 * Alice picks 16 coins [] = {2},
 * 
 * Bob picks 2
 * 
 * Alice: 6+1+16 =23
 * 
 * Bob: 9+8+2=19
 * 
 * => Alice Won
 */
public class CoinInALineGameProblem {

    public static int aliceMax = Integer.MIN_VALUE;
    public static int bobMax = 0;

    public static void main(String[] args) {
        int[] B = { 6, 9, 1, 2, 16, 8 };

        // Solution using recursion
        findMaxValueByRecursion(B, 0, B.length - 1, 0, 0, true);
        System.out.println("Max value pick up by player1(Alice) By Recursion: " + aliceMax);

        findMaxValueByDP(B);
    }

    public static void findMaxValueByRecursion(int arr[], int start, int end, int alice, int bob, boolean isAliceTurn) {
        if (alice >= aliceMax) {
            aliceMax = alice;
            bobMax = bob;
        }

        if (start > end) {
            return;
        }

        if (isAliceTurn) {
            findMaxValueByRecursion(arr, start + 1, end, alice + arr[start], bob, !isAliceTurn);
            findMaxValueByRecursion(arr, start, end - 1, alice + arr[end], bob, !isAliceTurn);
        } else {
            if (arr[start] > arr[end]) {
                findMaxValueByRecursion(arr, start + 1, end, alice, bob + arr[start], !isAliceTurn);
            } else {
                findMaxValueByRecursion(arr, start, end - 1, alice, bob + arr[end], !isAliceTurn);
            }
        }
    }

    public static void findMaxValueByDP(int arr[]) {
        int len = arr.length;
        Currency currency[][] = new Currency[len][len];
        for (int k = 0; k < len; k++) {
            for (int i = 0, j = k; j < len; i++, j++) {
                Currency c;
                // if only one currency
                if (i == j) {
                    c = new Currency(arr[i], 0);
                } else if (i == j - 1) { // if only 2 currency
                    if (arr[i] > arr[j]) {
                        c = new Currency(arr[i], arr[j]);
                    } else {
                        c = new Currency(arr[j], arr[i]);
                    }
                } else {
                    int temp1 = arr[i] + currency[i + 1][j].bob;
                    int temp2 = arr[j] + currency[i][j - 1].bob;

                    if (temp1 > temp2) {
                        c = new Currency(temp1, currency[i + 1][j].alice);
                    } else {
                        c = new Currency(temp2, currency[i][j - 1].alice);
                    }
                }
                currency[i][j] = c;
            }
        }
        System.out.println("Max value pick up by player1(Alice) By DP: " + currency[0][len - 1].alice);
    }

    static class Currency {
        int alice;
        int bob;

        public Currency(int alice, int bob) {
            this.alice = alice;
            this.bob = bob;
        }

        @Override
        public String toString() {
            return alice + " : " + bob;
        }
    }

}