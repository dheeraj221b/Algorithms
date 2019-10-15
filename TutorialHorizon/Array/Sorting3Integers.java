/**
 * Sorting3Integers
 */
public class Sorting3Integers {
    public static void main(String[] args) {
        int x = 4;
        int y = 1;
        int z = 9;

        int max = Math.max(x, Math.max(y, z));

        int min = -1 * Math.max(-1 * x, Math.max(-1 * y, -1 * z));

        int middle = (x + y + z) - max - min;

        System.out.println(max + " " + middle + " " + min);

    }
}