/**
 * SmallestSubArrayWithSumByGivenN
 */
public class SmallestSubArrayWithSumByGivenN {
    public static void main(String[] args) {
        // int[] arrA = { 1, 10, 3, 40, 18 };
        // int N = 50;

        int[] arrA = { 1, 5, 20, 70, 8 };
        int N = 97;

        int sum = arrA[0];
        int min = Integer.MAX_VALUE;

        int startIndex = 0, start = 0;
        int endIndex = 1, end = 1;
        int current = 1;

        if (sum > N) {
            min = 1;
        }

        while (current < arrA.length) {
            endIndex++;
            sum = sum + arrA[current];
            while (sum > N) {
                int size = endIndex - startIndex;
                if (size < min) {
                    start = startIndex;
                    end = endIndex;
                    min = size;
                }
                sum = sum - arrA[startIndex];
                startIndex++;
            }
            current++;
        }
        System.out.println("Min Len: " + min);
        System.out.print("SubArray is : ");
        for (int i = start; i < end; i++) {
            System.out.print(arrA[i] + " ");
        }
        System.out.println();
    }
}