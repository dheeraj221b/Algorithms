/**
 * FindMissingNumberFromSequence
 */
public class FindMissingNumberFromSequence {

    public static void main(String[] args) {
        int A[] = { 1, 2, 7, 6, 3, 4 };

        int range = 7;
        int a = 0;
        for (int i = 1; i <= range; i++) {
            a = a ^ i;
        }

        for (int i = 0; i < range - 1; i++) {
            a = a ^ A[i];
        }

        System.out.println("Missing Num is: " + a);

    }
}