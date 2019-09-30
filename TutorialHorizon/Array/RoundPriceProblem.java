import java.util.Arrays;
import java.util.Comparator;

/**
 * RoundPriceProblem
 * 
 * Objective: Write an algorithm to round each element in A such that after
 * rounding we get a new array B = [y1, y2, …., yn] such that y1 + y2 +…+ yn =
 * Target where yi = Floor(xi) or Ceil(xi), ceiling or floor of xi. Also
 * Minimize minimize sum (|x1-y1| + |x2-y2| +…..+ |xn-yn|)
 * 
 * Example:
 * 
 * input = 30.3, 2.4, 3.5 output = 30 2 4
 * 
 * input = 30.9, 2.4, 3.9 output = 31 2 4
 */
public class RoundPriceProblem {

    public static double minArr[];
    public static int finalArr[];
    public static double totalPrice = 0;
    public static double minDiff = Double.MAX_VALUE, minDigitDiff = Double.MAX_VALUE;

    public static void main(String[] args) {
        // double[] prices = { 30.9, 2.4, 3.9 };
        double[] prices = { 30.3, 2.4, 3.5 };

        minArr = new double[prices.length];
        finalArr = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            totalPrice = totalPrice + prices[i];
        }

        // Approach: Recursion Time Complexity O(2 ^ n)
        roundPriceWithMinimumDifference(prices, 0, 0, 0, minArr);
        System.out.println(Arrays.toString(finalArr));

        // Approach: Sorting Time Complexity O(NLongN)
        roundPriceWithSorting(prices);
        System.out.println(Arrays.toString(finalArr));
    }

    public static void roundPriceWithSorting(double prices[]) {

        int len = prices.length;
        CeilDiff arr[] = new CeilDiff[len];

        int target = 0;
        for (int i = 0; i < len; i++) {
            target = target + (int) Math.round(prices[i]);
        }

        // Difference between target and floor sum diff
        int d = target;

        for (int i = 0; i < len; i++) {
            int ceil = (int) Math.ceil(prices[i]);
            int floor = (int) Math.floor(prices[i]);
            double diff = ceil - prices[i];

            d = d - floor;
            arr[i] = new CeilDiff(ceil, floor, diff);
        }

        Arrays.sort(arr, new Comparator<CeilDiff>() {
            @Override
            public int compare(CeilDiff o1, CeilDiff o2) {
                if (o1.diffCeilWithPrice > o2.diffCeilWithPrice)
                    return 1;
                return -1;
            }
        });

        int i = 0;
        for (; i < d; i++) {
            finalArr[i] = arr[i].ceil;
        }

        for (; i < len; i++) {
            finalArr[i] = arr[i].floor;
        }
    }

    static class CeilDiff {
        int ceil;
        int floor;
        double diffCeilWithPrice;

        public CeilDiff(int ceil, int floor, double diffCeilWithPrice) {
            this.ceil = ceil;
            this.floor = floor;
            this.diffCeilWithPrice = diffCeilWithPrice;
        }

        @Override
        public String toString() {
            return diffCeilWithPrice + "";
        }
    }

    public static void roundPriceWithMinimumDifference(double arr[], int start, double price, double digitDiff,
            double minArr[]) {

        if (start == arr.length) {
            double diff = Math.abs(totalPrice - price);
            if (diff <= minDiff) {
                minDiff = diff;

                if (digitDiff < minDigitDiff) {
                    minDigitDiff = digitDiff;
                    for (int i = 0; i < arr.length; i++) {
                        finalArr[i] = (int) minArr[i];
                    }
                }
            }
            return;
        }

        minArr[start] = Math.ceil(arr[start]);
        roundPriceWithMinimumDifference(arr, start + 1, price + Math.ceil(arr[start]),
                digitDiff + Math.abs(arr[start] - minArr[start]), minArr);

        minArr[start] = Math.floor(arr[start]);
        roundPriceWithMinimumDifference(arr, start + 1, price + Math.floor(arr[start]),
                digitDiff + Math.abs(arr[start] - minArr[start]), minArr);

    }

}