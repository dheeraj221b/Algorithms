import java.util.Deque;
import java.util.LinkedList;
/**
 * CountSubArrayWithProdcutLessThanK
Objec­tive:  Given an array of positive integers and integer ‘K’. 
Write an algorithm to count all the possible sub arrays where product of all the 
elements in the sub array is less than k.

Example:

Int [] nums = {10, 4, 2, 6};
K = 100

Output: 9
Sub arrays: [10], [10 4], [10, 4, 2], [4], [4, 2], [4, 2, 6], [2], [2, 6], [6]
 */
public class CountSubArrayWithProdcutLessThanK {

    public static void main(String[] args) {
        int [] nums = {10,4,2,6};
        int sum = 100;

        //Naive Approach
        System.out.println("Naive Approach O(n^3)");
        //Find All Possible Array and find arrays which has product less than k
        countWithNaiveApproach(nums, sum);

        //Sliding Window Approach 
        System.out.println("Sliding Window Approach O(n)");
        countWithSlidingWindowAlgo(nums, sum);
    }

    public static void countWithNaiveApproach(int arr[], int sum) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int size = arr.length - i;
            for(int j=0;j<size;j++){
                int mul = 1;
                for(int k=i;k<=j+i;k++){
                    mul = mul * arr[k];
                }
                if(mul < sum){
                    count++;
                }
            }
        }
        System.out.println("Total SubArray: "+count);
    }

    public static void countWithSlidingWindowAlgo(int arr[], int sum) {
        Deque<Integer> deque = new LinkedList<>();

        int start = 0, end = 0;
        int count = 0;
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            deque.add(arr[i]);
            mul = mul * arr[i];
            end++;

            while(mul > sum){
                int num = deque.removeFirst();
                mul = mul / num;
                start++;
            }

            count = count + end - start;

        }

        System.out.println("Total SubArray: "+count);

    }

}