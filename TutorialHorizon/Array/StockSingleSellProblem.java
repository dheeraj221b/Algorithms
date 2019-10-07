/**
 * StockSingleSellProblem
 */
public class StockSingleSellProblem {
    public static void main(String[] args) {
        int[] arr = { 200, 500, 1000, 700, 30, 400, 900, 400, 50 };
        int min = arr[0];
        int max = arr[0];

        int diff = 0;

        int buyindIndex = 0;
        int sellingIndex = 0;

        int currentBuyingIndex = 0;
        int currentSellingIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                max = arr[i];

                currentBuyingIndex = i;
                currentSellingIndex = i;
            }

            if (arr[i] > max) {
                max = arr[i];
                currentSellingIndex = i;
            }

            if (max - min > diff) {
                diff = max - min;
                buyindIndex = currentBuyingIndex;
                sellingIndex = currentSellingIndex;
            }
        }

        System.out.println("Buying Index: " + buyindIndex + " Selling Index: " + sellingIndex + " Diff: " + diff);

    }
}