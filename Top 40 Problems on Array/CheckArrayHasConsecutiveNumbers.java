/**
 * CheckArrayHasConsecutiveNumbers
 */
public class CheckArrayHasConsecutiveNumbers {
    public static void main(String[] args) {
        // int[] arrA = { 21, 24, 22, 26, 23, 25 };
        // int[] arrB = { 11, 10, 12, 14, 13 };
        int[] arrC = { 11, 10, 14, 13 };
        checkArrayHasConsecutiveNumbers(arrC);
    }

    public static void checkArrayHasConsecutiveNumbers(int arr[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if (arr.length == max - min + 1) {
            boolean isConsecutive = true;
            int bufferArr[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i] - min;
                if (bufferArr[num] == 1) {
                    isConsecutive = false;
                    break;
                } else {
                    bufferArr[num] = 1;
                }
            }
            if (isConsecutive) {
                System.out.println("All consecutive numbers: True");
            } else {
                System.out.println("All consecutive numbers: False");
            }
        } else {
            System.out.println("All consecutive numbers: False");
        }
    }

}