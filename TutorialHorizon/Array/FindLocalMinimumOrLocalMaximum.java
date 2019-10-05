/**
 * FindLocalMinimumOrLocalMaximum
 * 
 * Objec­tive: Given an array such that every next element differs from the
 * previous by +/- 1. (i.e. a[i+1] = a[i] +/-1 ) Find the local max OR min in
 * O(1) time. The interviewer mentioned one more condition that the min or max
 * should be non-edge elements of the array
 * 
 * Example:
 * 
 * 1 2 3 4 5 4 3 2 1 -> Local maximum is 5
 * 
 * 5 4 3 2 1 2 3 4 5 -> Local minimum is 1
 * 
 * 1 2 3 4 5 -> No local max or min exists
 * 
 * 5 4 3 2 1 -> No local max or min exists
 */
public class FindLocalMinimumOrLocalMaximum {
    public static void main(String[] args) {
        // int a[] = { 3, 4, 5, 4, 3, 2, 1, 0, -1 };
        // int a[] = { 11, 4, 2, 5, 11, 13, 5 };
        int a[] = { -4, -5, -6, -5, -4, -3 };
        // int a[] = { 1, 2, 3, 2, 1, 0, -1, -2, -3 };
        // int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 7 };

        // Naive Approach O(n) time
        // findLocalMinimumOrMaximum(a);

        // Better Approach O(1) time
        findLocalMinimumOrMaximumBetter(a);
    }

    public static void findLocalMinimumOrMaximum(int a[]) {
        int i = 1;
        while (i + 1 < a.length && !(a[i - 1] > a[i] && a[i + 1] > a[i])) {
            i++;
        }

        if (i + 1 == a.length) {
            System.out.println("There is no local minimum");
        } else {
            System.out.println("Local Minimum: " + a[i]);
        }

        i = 1;
        while (i + 1 < a.length && !(a[i - 1] < a[i] && a[i + 1] < a[i])) {
            i++;
        }

        if (i + 1 == a.length) {
            System.out.println("There is no local maximum");
        } else {
            System.out.println("Local Maximum: " + a[i]);
        }
    }

    public static void findLocalMinimumOrMaximumBetter(int a[]) {
        int size = a.length;
        int last = a[size - 1];
        int start = a[0];

        // if all element are in ascending order

        if (a[1] > start) {
            // Local Maximum
            int lastShouldBe = start + size - 1;
            int localMaximum = (last + lastShouldBe) / 2;
            System.out.println("Local Maximum: " + localMaximum);
        } else {
            // Local Minimum
            int lastShouldBe = start - (size - 1);
            int localMinimum = (last + lastShouldBe) / 2;
            System.out.println("Local Minimum: " + localMinimum);
        }
    }

}