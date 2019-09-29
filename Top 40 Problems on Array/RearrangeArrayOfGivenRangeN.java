import java.util.Arrays;

/**
 * RearrangeArrayOfGivenRangeN
 */
public class RearrangeArrayOfGivenRangeN {

    public static void main(String[] args) {
        // int A[] = { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14,
        // 17, 4, };

        int A[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };

        int size = A.length;

        for (int i = 0; i < size; i++) {
            if (A[i] != -1 && A[i] != i) {
                int x = A[i];

                while (A[x] != -1 && A[x] != x) {
                    int temp = A[x];
                    A[x] = x;
                    x = temp;
                }

                A[x] = x;
                if (A[i] != i) {
                    A[i] = -1;
                }

            }
        }

        System.out.println(Arrays.toString(A));

    }
}