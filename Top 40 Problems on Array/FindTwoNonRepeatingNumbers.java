/**
 * FindTwoNonRepeatingNumbers
Objective:  Given an array of integers which has all the repeating numbers (twice) but two numbers 
which are non-repeating. Write an algorithm to find out those two numbers.
Example
int [] arrA = {4,5,4,5,3,2,9,3,9,8};
Output: 2 and 8
 */
public class FindTwoNonRepeatingNumbers {

    public static void main(String[] args) {
        int [] arr = {4,5,4,5,3,2,9,3,9,8};

        int res = arr[0];
        for(int i=1;i<arr.length;i++){
            res = res ^ arr[i];
        }

        int right_most_set_bit = res & ~(res - 1);

        int a = 0;
        int b = 0;

        for(int i=0;i<arr.length;i++){

            if((arr[i] & right_most_set_bit) != 0){
                a = a ^ arr[i];
                continue;
            }

            b = b ^ arr[i];
        }
        System.out.println(a +" , "+b);
    }
}