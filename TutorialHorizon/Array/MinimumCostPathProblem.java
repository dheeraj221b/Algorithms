/**
 * MinimumCostPathProblem
 */
public class MinimumCostPathProblem {

    public static void main(String[] args) {
        int[][] A = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 }, { 2, 9, 8, 2 } };

        int row = A.length;
        int col = A[0].length;

        int costArr[][] = new int[row][col];

        costArr[0][0] = A[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    costArr[i][j] = A[i][j] + Math.min(costArr[i - 1][j], costArr[i][j - 1]);
                } else if (i - 1 >= 0) {
                    costArr[i][j] = A[i][j] + costArr[i - 1][j];
                } else if (j - 1 >= 0) {
                    costArr[i][j] = A[i][j] + costArr[i][j - 1];
                }
            }
        }
        System.out.println("Minimum cost: " + costArr[row - 1][col - 1]);
    }
}