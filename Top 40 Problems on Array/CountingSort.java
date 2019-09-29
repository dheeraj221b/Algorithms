import java.util.Arrays;

/**
 * CountingSort
 */
public class CountingSort {
    public static void main(String[] args) {
        int input[] = { 2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4 };

        int count[] = new int[input.length + 1];

        for (int i = 0; i < input.length; i++) {
            count[input[i]] = count[input[i]] + 1;
        }

        for (int i = 1; i < input.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        System.out.println("Count Array: " + Arrays.toString(count));

        int sortArr[] = new int[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            int num = input[i];

            int pos = count[num];
            sortArr[pos] = num;
            count[num] = count[num] - 1;
        }

        System.out.println("Sorted Arr: " + Arrays.toString(sortArr));
    }
}