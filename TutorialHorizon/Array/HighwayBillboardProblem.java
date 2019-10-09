import java.util.Arrays;

/**
 * HighwayBillboardProblem
 */
public class HighwayBillboardProblem {

    public static void main(String[] args) {
        int[] x = { 6, 7, 12, 13, 14 };
        int[] revenue = { 5, 6, 5, 3, 1 };
        int distance = 20;
        int milesRestriction = 5;

        int len = x.length;
        int lastPos = x[len - 1];

        int revArr[] = new int[lastPos + 1];

        int index = 0;
        for (int i = 1; i < revArr.length; i++) {
            if (i == x[index]) {
                int rev = revenue[index];

                if (x[index] - milesRestriction > 0) {
                    int pos = x[index] - milesRestriction - 1;
                    rev = rev + revArr[pos];
                }

                if (rev < revArr[i - 1]) {
                    rev = revArr[i - 1];
                }

                revArr[i] = rev;
                index++;
            } else {
                revArr[i] = revArr[i - 1];
            }
        }

        System.out.println(Arrays.toString(revArr));
        System.out.println("Max Revenue: " + revArr[revArr.length - 1]);
    }
}