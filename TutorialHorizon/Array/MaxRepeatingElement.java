import java.util.Arrays;

/**
 * MaxRepeatingElement
 * 
 * This solution works only if array has positive integers and all the elements
 * in the array are in range from 0 to n-1 where n is the size of the array.
 */
public class MaxRepeatingElement {

    public static void main(String[] args) {
        int[] arr = { 4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7 };

        int size = arr.length;

        int maxCount = 0;
        int maxIndex = 0;

        for (int i = 0; i < size; i++) {
            int index = arr[i] % size;
            arr[index] = arr[index] + size;
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < size; i++) {
            if (arr[i] / size > maxCount) {
                maxCount = arr[i] / size;
                maxIndex = i;
            }
        }
        System.out.println("Element repeating maximum no of times: " + maxIndex + ", maximum count: " + maxCount);
    }
}