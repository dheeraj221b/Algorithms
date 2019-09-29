/**
 * RemoveDuplicatesFromString
Objective:  Given a string, write an algorithm to remove the duplicate characters in that string.
Example:
Input: tutorialhorizon
Output: tuorialhzn
 */

public class RemoveDuplicatesFromString {

    public static void main(String[] args) {
        String s = "tutorialhorizon";
        String s1 = "";
        
        // Buffer Array AApproach
        int arr[] = new int[256];
        for(int i=0;i<s.length();i++){
            int ascii= (int)s.charAt(i);

            if(arr[ascii] == 1){
                continue;
            }
            arr[ascii] = 1;
            s1 = s1 + s.charAt(i);
        }
        System.out.println(s1);
    }
}