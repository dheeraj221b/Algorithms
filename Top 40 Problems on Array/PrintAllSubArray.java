/**
 * PrintAllSubArray
 * Objective:  Given an array write an algorithm to print all the possible sub arrays.
 * Example:
 * int [] a = {1, 2, 3};
 * Output: Possible subarrays –
 * {1}, {2}, {3}, {1, 2} , {2, 3}, {1, 2, 3}
 */
public class PrintAllSubArray {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        
        //O(n^3) complexity
        printAllSubArray(arr);        
    }

    public static void printAllSubArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            
            for(int j=i;j<arr.length;j++){

                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                }
                System.out.println("");
            }
        }
    }

}