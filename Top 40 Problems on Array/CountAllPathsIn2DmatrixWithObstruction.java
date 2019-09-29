/**
 * CountAllPathsIn2DmatrixWithObstruction - Many times this problem is being
 * referred as “Robot Travel Problem“. Objective: Given two dimensional matrix,
 * write an algorithm to count all possible paths from top left corner to
 * bottom-right corner. You are allowed to move only in two directions, move
 * right OR move down. There are few obstructions as well, means few cells are
 * blocked and you cannot travel that cell.
 */
public class CountAllPathsIn2DmatrixWithObstruction {

    public static int row, col;

    public static void main(String[] args) {
        // int arrA[][] = { { 1, 1, 1 }, { 1, -1, 1 }, { 1, -1, 1 } };
        // int arrA[][] = { { 1, 1, 1 }, { 1, -1, 1 }, { 1, 1, 1 } };
        int arrA[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, -1, 1 } };
        row = arrA.length;
        col = arrA[0].length;

        countAllPathsUsingDynamicProgramming(arrA);

        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printAllPathWithoutObstruction(a, 0, 0, "");
    }

    public static void printAllPathWithoutObstruction(int arr[][], int row, int col, String path) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.println(path + " -> " + arr[row][col]);
        }

        path = path + " -> " + arr[row][col];
        if (row + 1 < arr.length) {
            printAllPathWithoutObstruction(arr, row + 1, col, path);
        }
        if (col + 1 < arr[0].length) {
            printAllPathWithoutObstruction(arr, row, col + 1, path);
        }

    }

    public static void countAllPathsUsingDynamicProgramming(int arrA[][]) {
        int result[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arrA[i][j] == -1) {
                    result[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        result[i][j] = 1;
                    } else if (i != 0 && j != 0) {
                        result[i][j] = result[i - 1][j] + result[i][j - 1];
                    } else if (i == 0) {
                        result[i][j] = result[i][j - 1];
                    } else {
                        result[i][j] = result[i - 1][j];
                    }
                }
            }
        }
        System.out.println("Total Paths: " + result[row - 1][col - 1]);
    }

}