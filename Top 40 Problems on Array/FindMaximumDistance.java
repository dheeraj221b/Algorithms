/**
 * FindMaximumDistance
 */
public class FindMaximumDistance {

    public static void main(String[] args) {
        int[] arrA = { 12, 3, 1, 5, 6, 4, 10, 9, 8, 0 };

        int maxDistance = Integer.MIN_VALUE;

        for (int i = arrA.length - 1; i >= 0; i--) {

            int j = 0;
            while (j < i) {
                if (arrA[i] > arrA[j]) {
                    int distance = i - j;
                    if (distance > maxDistance) {
                        maxDistance = distance;
                    }
                }
                j++;
            }
        }

        System.out.println("Max Distance: " + maxDistance);
    }
}