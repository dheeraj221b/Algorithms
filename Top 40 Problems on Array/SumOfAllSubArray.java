/**
 * SumOfAllSubArray
Objec­tive:  Given an array write an algorithm to find the sum of all the possible sub arrays.

Example:

int [] a = {1, 2, 3};

Output: Possible subarrays –
{1}, {2}, {3}, {1, 2} , {2, 3}, {1, 2, 3}
So sum = 1+ 2+ 3 + 3 + 5 + 6 = 20
 */
public class SumOfAllSubArray {

    public static void main(String[] args) {
        //int [] a = {1, 2, 3};
        int [] a = {1,2,3,4,8,6,9,10,14,16,19,43,23};
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum = sum + ((a.length - i) * a[i]) + (a.length - i)* a[i] * i;
        }

        System.out.println(sum);
    }
}