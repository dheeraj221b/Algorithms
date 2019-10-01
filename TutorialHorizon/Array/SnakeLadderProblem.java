/**
 * SnakeLadderProblem
 */
public class SnakeLadderProblem {

    static int minJump = -1;

    public static void main(String[] args) {
        int size = 36;
        int[] board = new int[size];
        for (int i = 0; i < size; i++) {
            board[i] = -1;
        }

        board[2] = 15;
        board[14] = 24;
        board[20] = 31;

        // Snakes
        board[11] = 1;
        board[29] = 3;
        board[34] = 21;

        int trackArr[] = new int[size];

        for (int i = 1; i < size; i++) {
            trackArr[i] = Integer.MAX_VALUE;
        }

        findMinimumJump(board, 0, trackArr);
        minJump = trackArr[size - 1] == Integer.MAX_VALUE ? -1 : trackArr[size - 1];
        System.out.println("Min Jump: " + minJump);
    }

    public static void findMinimumJump(int board[], int current, int trackArr[]) {

        if (current == (board.length - 1)) {
            return;
        }

        if (board[current] == 0) {
            return;
        }

        if (board[current] != -1) {
            trackArr[board[current]] = trackArr[current];
            current = board[current];
        }

        for (int i = 1; i <= 6; i++) {
            if ((current + i) < trackArr.length) {
                if ((trackArr[current] + 1) < trackArr[current + i]) {
                    trackArr[current + i] = trackArr[current] + 1;
                    findMinimumJump(board, (current + i), trackArr);
                }
            }
        }

    }

}