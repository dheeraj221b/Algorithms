import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * GenerateMaximumRevenueBySellingKTickets Objective: Given ‘N’ windows where
 * each window contains certain number of tickets at each window. Price of a
 * ticket is equal to number of tickets remaining at that window. Write an
 * algorithm to sell ‘k’ tickets from these windows in such a manner so that it
 * generates the maximum revenue.
 */
public class GenerateMaximumRevenueBySellingKTickets {

    public static void main(String[] args) {
        int[] arr = { 5, 1, 7, 10, 11, 9 };
        int noOfTickets = 5;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(arr.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        System.out.println(queue);

        int revenue = 0;
        for (int i = 0; i < noOfTickets; i++) {
            int maxPrice = queue.poll();
            revenue = revenue + maxPrice;
            queue.add(maxPrice - 1);
        }
        System.out.println("Max Revenue by selling " + noOfTickets + " tickets: " + revenue);
    }
}