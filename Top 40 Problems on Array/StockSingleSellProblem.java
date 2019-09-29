/**
 * StockSingleSellProblem
Objec­tive:  Given an array represents cost of a stock on each day. You are allowed to buy 
and sell the stock only once. Write an algorithm to maximize the profit in single buy and sell.

Exam­ple:

int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
Output: Maximum Profit: 870, buy date index: 4, sell date index: 6
 */
public class StockSingleSellProblem {

    public static void main(String[] args) {

        int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50, 2000, 400};

        int min = 0, currMin = 0;
        int max = 0, currMax = 0;
        int profit =  0;


        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[currMin]){
                currMin = i;
                currMax = i;
            }else if(prices[i] > prices[currMax]){
                currMax = i;
                int currProfit = prices[currMax] - prices[currMin];
                if(currProfit > profit){
                    min = currMin;
                    max = currMax;
                    profit = currProfit;
                }
            }
        }
        System.out.println("Buy Price: "+ prices[min]+" Selling Price: "+prices[max]+ " Profit: "+profit);
    }
}