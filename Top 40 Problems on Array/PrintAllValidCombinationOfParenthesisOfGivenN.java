/**
 * PrintAllValidCombinationOfParenthesisOfGivenN
 * 
 * Objec­tive: – Given “n”, generate all valid parenthesis strings of length
 * “2n”. Example:
 * 
 * Given n=2
 * 
 * Output: (()) ()()
 */
public class PrintAllValidCombinationOfParenthesisOfGivenN {
    public static void main(String[] args) {
        int n = 4;
        findAllValidCombination(n, 0, 0, "");
    }

    public static void findAllValidCombination(int n, int start, int open, String combination) {
        if (start == 2 * n) {
            if (open == 0) {
                System.out.println("Print Combination: " + combination);
            } else {
                // System.out.println("Invalid Combination: " + combination);
            }
            return;
        }

        if (open < n)
            findAllValidCombination(n, start + 1, open + 1, combination + "(");

        if (open > 0)
            findAllValidCombination(n, start + 1, open - 1, combination + ")");

    }
}