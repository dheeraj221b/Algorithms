/**
 * SubArraySum
 */
public class SubArraySum {
    public static void main(String[] args) {
        int[] arrA = { 1, 2, 3, 4, 5 };
        int len = arrA.length;
        int total = 0;
        for (int i = 0; i < len; i++) {
            total = total + (len - i) * arrA[i] + (i * (len - i) * arrA[i]);
        }
        System.out.println("Total: " + total);
    }
}