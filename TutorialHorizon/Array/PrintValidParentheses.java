/**
 * PrintValidParentheses
 */
public class PrintValidParentheses {

    public static void main(String[] args) {
        int n = 3;
        printAllValidCombination("", 0, 0, n);
    }

    public static void printAllValidCombination(String paren, int open, int close, int n) {

        if (close > open || open > n || close > n) {
            return;
        }

        if (open == close && open == n) {
            System.out.println(paren);
            return;
        }

        printAllValidCombination(paren + ")", open, close + 1, n);
        printAllValidCombination(paren + "(", open + 1, close, n);
    }

}