/**
 * PrintArrayElementInSpiral
 */
public class PrintArrayElementInSpiral {
    public static void main(String[] args) {
        int arrA[][] = { { 1, 2, 3, 4, 5 }, { 18, 19, 20, 21, 6 }, { 17, 28, 29, 22, 7 }, { 16, 27, 30, 23, 8 },
                { 15, 26, 25, 24, 9 }, { 14, 13, 12, 11, 10 } };

        // int arrA[][] = { { 1, 2, 3, 4 }, { 14, 15, 16, 5 }, { 13, 20, 17, 6 }, { 12,
        // 19, 18, 7 }, { 11, 10, 9, 8 } };

        // int arrA[][] = { { 2, 3, 1, 6 }, { 12, 13, 5, 7 }, { 8, 4, 11, 9 } };

        // int arrA[][] = { { 1, 2, 3 }, { 4, 5, 6 } };

        int row = arrA.length;
        int col = arrA[0].length;

        int rowStart = 0;
        int colStart = 0;
        int rowEnd = row - 1;
        int colEnd = col - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            int i = colStart;
            while (i <= colEnd) {
                System.out.print(arrA[rowStart][i] + " ");
                i++;
            }

            if (i == colStart)
                break;

            i--;
            rowStart++;

            int j = rowStart;
            while (j <= rowEnd) {
                System.out.print(arrA[j][i] + " ");
                j++;
            }

            if (j == rowStart)
                break;

            j--;
            colEnd--;

            int k = colEnd;
            while (k >= colStart) {
                System.out.print(arrA[j][k] + " ");
                k--;
            }

            if (k == colEnd)
                break;

            k++;
            rowEnd--;

            int l = rowEnd;
            while (l >= rowStart) {
                System.out.print(arrA[l][k] + " ");
                l--;
            }

            if (l == rowEnd)
                break;

            colStart++;
        }

    }
}