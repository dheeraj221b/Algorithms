import java.util.HashSet;
import java.util.Iterator;

/**
 * SumOfUniqueElementsInGivenArray
 * 
 * Objective: Given an array of integers that contains duplicates as well. Write
 * a program to find the sum of all unique elements in the array. This problem
 * is also referred to as find the sum of all distinct elements in the array
 * 
 * Example:
 * 
 * [] arrA = {1, 6, 4, 3, 2, 2, 3, 8, 1}; Output : 24 (Unique elements are: 1,
 * 6, 4, 3, 2, 8)
 * 
 * [] arrA = {1, 1, 3, 2, 2, 3}; Output : 6 (Unique elements are: 1, 2, 3)
 */
public class SumOfUniqueElementsInGivenArray {

    public static void main(String[] args) {
        int[] arrA = { 1, 6, 4, 3, 2, 2, 3, 8, 1 };
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arrA.length; i++) {
            set.add(arrA[i]);
        }

        Iterator<Integer> iterator = set.iterator();
        int total = 0;
        while (iterator.hasNext()) {
            total = total + iterator.next();
        }
        System.out.println(total);
    }
}