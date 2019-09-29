/**
 * PrintDiagonalOfMatrix
 */
public class PrintDiagonalOfMatrix {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4, 5 }, { 5, 6, 7, 8, 9 }, { 9, 10, 11, 12, 13 }, { 13, 14, 15, 16, 17 },
                { 18, 19, 20, 21, 22 } };

        int row = a.length;
        int col = a[0].length;

        for (int i = 0; i < row; i++) {
            int start = i;
            for (int j = 0; j <= i; j++) {
                System.out.print(a[start][j] + " ");
                start--;
            }
            System.out.println();
        }

        for (int i = row - 1; i >= 0; i--) {

            int start = row - 1;
            int j = col - i;
            while (start > 0 && j < col) {
                System.out.print(a[start][j] + " ");
                start--;
                j++;
            }
            System.out.println();
        }
    }
}