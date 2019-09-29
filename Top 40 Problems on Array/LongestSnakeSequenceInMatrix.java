/**
 * LongestSnakeSequenceInMatrix Objective: Given two dimensional matrix, write
 * an algorithm to find out the snake sequence which has the maximum length.
 * There could be many snake sequence in the matrix, you need to return the one
 * with the maximum length. Travel is allowed only in two directions, either go
 * right OR go down.
 */
public class LongestSnakeSequenceInMatrix {

    public static int maxLen = 0;
    public static int row, col;
    public static boolean trackMatrix[][];

    public static void main(String[] args) {
        int arrA[][] = { { 1, 2, 1, 2 }, { 7, 7, 2, 5 }, { 6, 4, 3, 4 }, { 1, 2, 2, 5 } };

        row = arrA.length;
        col = arrA[0].length;

        // Recursion
        findLongestSnakeSequenceUsingRecursion(arrA);
        System.out.println("Snake Sequence Max Length using recursion is: " + maxLen);

        // Dynamic Programming
        maxLen = 0;
        findLongestSnakeSequenceUsingDynamicProgramming(arrA);
        System.out.println("Snake Sequence Max Length using dynamic programming is: " + maxLen);

    }

    public static void findLongestSnakeSequenceUsingRecursion(int arrA[][]) {
        trackMatrix = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!trackMatrix[i][j]) {
                    findLongestSnakeSequence(arrA, i, j, 1);
                }
            }
        }
    }

    public static void findLongestSnakeSequence(int arrA[][], int i, int j, int count) {
        trackMatrix[i][j] = true;
        if (i + 1 < row && Math.abs(arrA[i][j] - arrA[i + 1][j]) == 1) {
            findLongestSnakeSequence(arrA, i + 1, j, count + 1);
        }
        if (j + 1 < col && Math.abs(arrA[i][j] - arrA[i][j + 1]) == 1) {
            findLongestSnakeSequence(arrA, i, j + 1, count + 1);
        }
        if (count > maxLen) {
            maxLen = count;
        }
    }

    public static void findLongestSnakeSequenceUsingDynamicProgramming(int arrA[][]) {
        int result[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = 1;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i != 0 && Math.abs(arrA[i][j] - arrA[i - 1][j]) == 1) {
                    result[i][j] = Math.max(result[i][j], result[i - 1][j] + 1);
                }

                if (j != 0 && Math.abs(arrA[i][j] - arrA[i][j - 1]) == 1) {
                    result[i][j] = Math.max(result[i][j], result[i][j - 1] + 1);
                }

                if (result[i][j] > maxLen) {
                    maxLen = result[i][j];
                }
            }
        }
    }

}