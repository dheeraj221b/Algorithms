/**
 * IntersecionPoint2Arrays
 */
public class IntersecionPoint2Arrays {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 6, 8, 10 };
        int[] b = { 4, 5, 6, 11, 15, 20 };

        int intersection = findIntersectionPoint(a, b);
        System.out.println("Intersection point: " + intersection);
    }

    public static int findIntersectionPoint(int a[], int b[]) {

        int a_start = 0;
        int b_start = 0;

        while (a_start < a.length && b_start < b.length && a[a_start] != b[b_start]) {
            if (a[a_start] > b[b_start]) {
                b_start++;
            } else if (a[a_start] < b[b_start]) {
                a_start++;
            }
        }
        if (a[a_start] == b[b_start]) {
            return a[a_start];
        }
        return -1;
    }

}