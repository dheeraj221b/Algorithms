import java.util.*;

class MissingNumberConsecutiveSequence {
    public static void main(String args[]) {
        findOneMissingNumber();
        findTwoMissingNumber();
    }

    public static void findOneMissingNumber() {
        int[] arrA = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
        int size = arrA.length + 1;
        int sumToBe = (size * (size + 1)) / 2;
        int actualSum = 0;
        for (int i = 0; i < arrA.length; i++) {
            actualSum = actualSum + arrA[i];
        }

        int missingNum = sumToBe - actualSum;
        System.out.println("Missing num: " + missingNum);
    }

    public static void findTwoMissingNumber() {
        int[] arrA = { 10, 2, 3, 5, 7, 8, 9, 1 };
        int size = arrA.length + 2;

        int sumToBe = (size * (size + 1)) / 2;
        int mulToBe = 1;
        for (int i = 1; i <= size; i++) {
            mulToBe = mulToBe * i;
        }
        int actualSum = 0;
        int actualMul = 1;
        for (int i = 0; i < arrA.length; i++) {
            actualSum = actualSum + arrA[i];
            actualMul = actualMul * arrA[i];
        }

        int remMul = mulToBe - actualMul; // a * b = num1
        int remSum = sumToBe - actualSum; // a + b = num2

        

    }

}