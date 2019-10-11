import java.util.Arrays;

/**
 * PrintAllPermutationOfString
 */
public class PrintAllPermutationOfString {

    public static void main(String[] args) {
        String s = "Interview";
        printAllPermutation(s.toCharArray(), 0, s.length());
    }

    public static void printAllPermutation(char arr[], int left, int size) {

        if (left == size) {
            if (wellOrdered(arr)) {
                System.out.println(Arrays.toString(arr));
            }
        }

        for (int i = left; i < size; i++) {
            swap(arr, left, i);
            printAllPermutation(arr, left + 1, size);
            swap(arr, left, i);
        }
    }

    public static void swap(char arr[], int left, int i) {
        char temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
    }

    public static boolean wellOrdered(char arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            char c1 = Character.toLowerCase(arr[i]);
            char c2 = Character.toLowerCase(arr[i + 1]);

            if (c1 > c2) {
                return false;
            }
        }

        return true;
    }

}