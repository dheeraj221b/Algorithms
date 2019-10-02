/**
 * SubarrayProductLessThanK
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = { 10, 4, 2, 6, 5, 1 };
        int k = 100;
        findAllSubArray(nums, k);
    }

    public static void findAllSubArray(int arr[], int k) {
        int product = 1;
        int count = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            product = product * arr[i];

            while (product > k) {
                product = product / arr[start];
                start++;
            }

            count = count + (i + 1 - start);
        }

        System.out.println("Total Subarray Count: " + count);
    }
}