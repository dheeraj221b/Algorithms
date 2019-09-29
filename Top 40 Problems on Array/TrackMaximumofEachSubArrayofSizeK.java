import java.util.Deque;
import java.util.LinkedList;


/**
 * TrackMaximumofEachSubArrayofSizeK
Objective: 
Given an array and integer k, write an algorithm to find the maximum element in each subarray of size k.

Example:

int [] nums = { 1, 2, 3, 2, 4, 1, 5, 6,1};
Output: 3, 3, 4, 4, 5, 6, 6
Subarrays –
[1, 2, 3], max = 3
[2, 3, 2], max = 3
[3, 2, 4], max = 4
[2, 4, 1], max = 4
[4, 1, 5], max = 5
[1, 5, 6], max = 6
[5, 6, 1], max = 6
 */

 public class TrackMaximumofEachSubArrayofSizeK {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 2, 4, 1, 5, 6, 1};
        int k =3;
        
        //Naive Approach
        System.out.println("Naive Approach");
        findMaximumOfEachSubArray(arr, k);
        System.out.println("Sliding Window Approach");
        //SlidingWindowApproach
        findMaximumOfEachSubArraySlidingWindow(arr, k);
    }

    //Complexity O(nk)
    public static void findMaximumOfEachSubArray(int arr[], int k){
        for(int i=0;i<=arr.length-k;i++){
            int max = -1;
            for(int j=0;j<k;j++){
                if(arr[i+j] > max){
                    max = arr[i+j];
                }
            }
            System.out.println(max);
        }
    }

    public static void findMaximumOfEachSubArraySlidingWindow(int arr[], int k){
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);
        for(int i=1;i<arr.length;i++){           
                while(deque.size() > 0){
                    int index = deque.peekLast();
                    int num = arr[index];
                    if(arr[i] >= num){
                        deque.removeLast();
                    }
                    else{
                        break;
                    }
                }
                deque.add(i);
                if(i+1 >= k)
                System.out.println(arr[deque.peek()]);
        }
    }

}