import java.util.Arrays;

/**
 * MaximumDistance
 */
public class MaximumDistance {

    public static void main(String[] args) {
        int[] arrA = { 12, 3, 1, 5, 6, 4, 10, 9, 8, 0 };

        int LMin[] = new int[arrA.length];
        int RMax[] = new int[arrA.length];

        LMin[0] = arrA[0];
        int min_so_far = arrA[0];

        for (int i = 1; i < arrA.length; i++) {
            if (arrA[i] < min_so_far) {
                min_so_far = arrA[i];
            }
            LMin[i] = min_so_far;
        }

        int max_so_far = arrA[arrA.length - 1];
        for (int i = arrA.length - 2; i >= 0; i--) {
            if (arrA[i] > max_so_far) {
                max_so_far = arrA[i];
            }
            RMax[i] = max_so_far;
        }

        int i = 0;
        int j = 0;
        int dist_so_far = -1;

        while (i < arrA.length && j < arrA.length) {
            if (LMin[i] < RMax[j]) {
                if (j - i > dist_so_far) {
                    dist_so_far = j - i;
                }
                j++;
            } else {
                i++;
            }
        }
        System.out.println("Max (j-i) where j > i and A[j] > A[i] is: " + dist_so_far);
    }
}