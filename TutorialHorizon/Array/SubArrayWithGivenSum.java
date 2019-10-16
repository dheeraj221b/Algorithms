import java.util.Deque;
import java.util.LinkedList;

/**
 * SubArrayWithGivenSum
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arrA = { 25, 12, 14, 22, 19, 15, 10, 23 };
        int sum = 55;

        findSubArray(arrA, sum);
    }

    // sliding window approach
    public static void findSubArray(int arr[], int givenSum) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(arr[0]);
        int sum = arr[0];
        int start = 1;

        while (start < arr.length) {
            if (sum == givenSum) {
                System.out.println(deque);
                break;
            } else if (sum < givenSum) {
                deque.addLast(arr[start]);
                sum = sum + arr[start];
                start++;
            } else {
                int num = deque.removeFirst();
                sum = sum - num;
            }
        }

    }

}