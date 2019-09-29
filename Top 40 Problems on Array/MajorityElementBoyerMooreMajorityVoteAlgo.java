/**
 * MajorityElementBoyerMooreMajorityVoteAlgo
Objec­tive:  Given an array of integer write an algorithm to find the majority element in it (if exist).

Majority Element: If an element appears more than n/2 times in array where n is the size of the array.

Example:

int [] arrA = {1,3,5,5,5,5,4,1,5};
Output: Element appearing more than n/2 times: 5

int []arrA = {1,2,3,4};
Output: No element appearing more than n/2 time
 */
public class MajorityElementBoyerMooreMajorityVoteAlgo {

    public static void main(String[] args) {
        int [] arrA = {1,3,5,5,5,5,4,1,5};

        int current_element = arrA[0];
        int majority_element = current_element;
        int count = 1;
        for (int i = 1; i < arrA.length; i++) {
            current_element = arrA[i];

            if(current_element == majority_element){
                count++;
                continue;
            }

            count--;
            majority_element = current_element;
        }

        count = 0;
        for (int i = 0; i < arrA.length; i++) {
            if(arrA[i] == majority_element){
                count++;
            }
        }

        if(count > arrA.length /2 ){
            System.out.println("Majority Element is: "+majority_element);
        }else{
            System.out.println("Majority element not found");
        }
    }
}