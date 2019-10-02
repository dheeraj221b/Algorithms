import java.util.Deque;
import java.util.LinkedList;

/**
 * TrackMaximumOfSubarraySizeK
 */
public class TrackMaximumOfSubarraySizeK {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 4, 1, 5, 6, 1, 2, 1 };
        int k = 3;

        findMaximumOfSubarrayOfSizeK(nums, k);
    }

    public static void findMaximumOfSubarrayOfSizeK(int arr[], int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        System.out.print(arr[deque.peek()] + " ");
        for (int i = k; i < arr.length; i++) {

            if (!deque.isEmpty() && (i - deque.getFirst() >= k)) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.add(i);
            System.out.print(arr[deque.peek()] + " ");
        }
        System.out.println();
    }

}