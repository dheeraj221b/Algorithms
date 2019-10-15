import java.util.Arrays;

/**
 * CountingSort
 */
public class CountingSort {
    public static void main(String[] args) {
        // int input[] = { 2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4 };
        int input[] = { 2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4 };
        int count[] = new int[input.length + 1];

        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            count[num] = count[num] + 1;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int res[] = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            int pos = count[num] - 1;
            res[pos] = num;
            count[num] = count[num] - 1;
        }

        System.out.println(Arrays.toString(res));

    }
}