import java.util.Arrays;

/**
 * NQueensProblem
 */
public class NQueensProblem {

    public static void main(String[] args) {
        int size = 4;

        int board[][] = new int[size][size];

        solveQueensProblem(board, 0, size);

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static boolean solveQueensProblem(int solution[][], int queen, int N) {

        if (queen == N) {
            return true;
        }

        for (int row = 0; row < N; row++) {
            if (canPlace(solution, row, queen)) {
                solution[row][queen] = 1;
                if (solveQueensProblem(solution, queen + 1, N)) {
                    return true;
                }
                solution[row][queen] = 0;
            }
        }
        return false;
    }

    public static boolean canPlace(int solution[][], int row, int col) {
        for (int i = 0; i < col; i++) {
            if (solution[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (solution[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal
        for (int i = row, j = col; i < solution.length && j >= 0; i++, j--) {
            if (solution[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}