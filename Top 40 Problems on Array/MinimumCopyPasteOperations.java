import java.util.*;

/**
 Objective: You have given a character ‘A’ which is already printed. You are allowed to perform only 2 operations –
1. Copy All – This operation will copy all the printed characters.
2. Paste – This operation will paste all the characters which are already copied.
Given a number N, write an algorithm to print character ‘A’ exactly N times with minimum no of 
operations (either copy all or paste)
 */

public class MinimumCopyPasteOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number");
        int num = sc.nextInt();
        int opr = 0;
        int curr = 2;

        while(num > curr){
            if(num % curr == 0){
                num = num / curr;
                opr = opr + curr;
                curr = 2;
            }else{
                curr++;
            }
        }

        System.out.println(num + opr);   
        sc.close();
    }
}