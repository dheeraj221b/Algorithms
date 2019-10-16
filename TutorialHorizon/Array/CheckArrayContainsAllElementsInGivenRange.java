/**
 * CheckArrayContainsAllElementsInGivenRange
 */
public class CheckArrayContainsAllElementsInGivenRange {

    public static void main(String[] args) {
        int[] arrA = { 11, 17, 13, 19, 15, 16, 12, 14 };
        int x = 12;
        int y = 15;

        for (int i = 0; i < arrA.length; i++) {
            int num = arrA[i];

            if (num >= x && num <= y) {
                int range = num - x;
                if (arrA[range] > 0) {
                    arrA[range] = -1 * arrA[range];
                }
            }
        }

        int range = y - x;

        if (range > arrA.length) {
            System.out.println(false);
            return;
        }
        boolean containRange = true;
        for (int i = 0; i <= range; i++) {
            if (arrA[i] > 0) {
                containRange = false;
                break;
            }
        }

        System.out.println(containRange);

    }
}