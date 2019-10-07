import java.util.Arrays;

/**
 * SumCloseToZero
 */
public class SumCloseToZero {

    public static void main(String[] args) {
        int a[] = { 1, 4, -5, 3, -2, 10, -6, 20 };
        // int a[] = { -5, 5, 8 };
        // int a[] = { 5, 8 };
        // int a[] = { -5, -5, -8 };

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int i = 0;
        int j = a.length - 1;
        int minSum = Integer.MAX_VALUE;
        int result = minSum;

        while (i < j) {
            int sum = a[j] + a[i];

            if (sum > 0) {
                j--;
            } else {
                i++;
            }

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                result = sum;
            }
        }

        System.out.println("Sum Closest to zero: " + result);

    }
}