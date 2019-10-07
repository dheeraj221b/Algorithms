/**
 * LongestSnakeSequence
 */
public class LongestSnakeSequence {

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 1, 2 }, { 7, 7, 2, 5 }, { 6, 4, 3, 4 }, { 1, 2, 2, 5 } };

        int row = arr.length;
        int col = arr[0].length;

        int longestSnake[][] = new int[row][col];
        int max = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i - 1 >= 0 && Math.abs(arr[i - 1][j] - arr[i][j]) == 1) {
                    if (longestSnake[i - 1][j] + 1 > longestSnake[i][j]) {
                        longestSnake[i][j] = longestSnake[i - 1][j] + 1;
                    }
                }

                if (j - 1 >= 0 && Math.abs(arr[i][j - 1] - arr[i][j]) == 1) {
                    if (longestSnake[i][j - 1] + 1 > longestSnake[i][j]) {
                        longestSnake[i][j] = longestSnake[i][j - 1] + 1;
                    }
                }

                if (longestSnake[i][j] > max) {
                    max = longestSnake[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        printPath(arr, longestSnake, maxRow, maxCol);
        System.out.println("max Length is: " + (max + 1));
    }

    public static void printPath(int arr[][], int longestSnake[][], int maxRow, int maxCol) {
        while (maxRow > 0 && maxCol > 0) {
            System.out.print(" - " + arr[maxRow][maxCol]);
            if (longestSnake[maxRow - 1][maxCol] == longestSnake[maxRow][maxCol] - 1) {
                maxRow--;
            } else if (longestSnake[maxRow][maxCol - 1] == longestSnake[maxRow][maxCol] - 1) {
                maxCol--;
            }
        }

        if (maxRow > 0) {
            int col = 0;
            while (maxRow >= 0) {
                System.out.print(" - " + arr[maxRow][col]);
                maxRow--;
            }
        }

        if (maxCol > 0) {
            int row = 0;
            while (maxCol >= 0) {
                System.out.print(" - " + arr[row][maxCol]);
                maxCol--;
            }
        }

        System.out.println("");
    }

}