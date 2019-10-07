import java.util.Arrays;

/**
 * EditDistanceProblemDP
 * 
 * Objective: Given two strings, s1 and s2 and edit operations (given below).
 * Write an algorithm to find minimum number operations required to convert
 * string s1 into s2.
 * 
 * Allowed Operations:
 * 
 * Insertion – Insert a new character.
 * 
 * Deletion – Delete a character.
 * 
 * Replace – Replace one character by another. Example:
 * 
 * String s1 = "horizon" String s2 = "horzon" Output: 1 {remove 'i' from string
 * s1}
 * 
 * String s1 = "horizon" String s2 = "horizontal" Output: 3 {insert 't', 'a',
 * 'l' characters in string s1}
 * 
 */
public class EditDistanceProblemDP {

    public static int minOpr = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "dog";

        // String s1 = "a";
        // String s2 = "cdabamlope";

        findMinimumOperationsUsingRecursion(s1, s2);

        findMinimumOperationsUsingDP(s1, s2);

        System.out.println("Minimum operations using recursion: " + minOpr);
    }

    public static void findMinimumOperationsUsingDP(String s1, String s2) {
        int row = s1.length() + 1;
        int col = s2.length() + 1;

        int count[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            count[i][0] = i;
        }

        for (int i = 0; i < col; i++) {
            count[0][i] = i;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    count[i][j] = count[i - 1][j - 1];
                } else {
                    count[i][j] = 1 + Math.min(count[i - 1][j - 1], Math.min(count[i - 1][j], count[i][j - 1]));
                }
            }
        }

        System.out.println("Minimum Operation using DP: " + count[row - 1][col - 1]);
    }

    public static void findMinimumOperationsUsingRecursion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            findMinimumOperations(s1, s2, 0, 0);
        } else {
            findMinimumOperations(s2, s1, 0, 0);
        }
    }

    // convert s1 into s2(minimum length string)
    public static void findMinimumOperations(String s1, String s2, int currentIndex, int operation) {
        if (s1.equals(s2)) {
            if (operation < minOpr) {
                minOpr = operation;
            }
        }

        if (operation > minOpr) {
            return;
        }
        if (currentIndex == s1.length()) {
            return;
        }

        if (currentIndex == s2.length()) {
            // only delete operation can be performed
            String ds1 = s1.substring(0, currentIndex) + s1.substring(currentIndex + 1);
            findMinimumOperations(ds1, s2, currentIndex, operation + 1);
        } else if (s1.charAt(currentIndex) == s2.charAt(currentIndex)) {
            findMinimumOperations(s1, s2, currentIndex + 1, operation);
        } else {
            // delete operation
            String ds1 = s1.substring(0, currentIndex) + s1.substring(currentIndex + 1);
            findMinimumOperations(ds1, s2, currentIndex, operation + 1);

            // add operation
            String as1 = s1.substring(0, currentIndex) + s2.charAt(currentIndex) + s1.substring(currentIndex);
            findMinimumOperations(as1, s2, currentIndex + 1, operation + 1);

            // replace operaration
            String rs1 = s1.substring(0, currentIndex) + s2.charAt(currentIndex) + s1.substring(currentIndex + 1);
            findMinimumOperations(rs1, s2, currentIndex + 1, operation + 1);
        }

    }

}