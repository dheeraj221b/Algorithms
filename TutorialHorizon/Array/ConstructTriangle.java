import java.util.Arrays;

/**
 * ConstructTriangle
 */
public class ConstructTriangle {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        constructTriangle(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void constructTriangle(int arr[]) {

        if (arr.length <= 1) {
            return;
        }

        int len = arr.length;
        int newArr[] = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            newArr[i] = arr[i] + arr[i + 1];
        }
        constructTriangle(newArr);
        System.out.println(Arrays.toString(newArr));
    }

}