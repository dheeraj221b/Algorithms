/**
 * TwoNonRepeatingXOR
 */
public class TwoNonRepeatingXOR {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 4, 5, 3, 2, 9, 3, 9, 8 };

        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        int kth = findKthSetBit(res);

        int a = 0;
        int b = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & kth) > 0) {
                a = a ^ arr[i];
            } else {
                b = b ^ arr[i];
            }
        }
        System.out.println(a + " : " + b);
    }

    public static int findKthSetBit(int num) {
        return num & (~(num - 1));
    }

}