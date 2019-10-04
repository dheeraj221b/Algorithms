import java.util.Arrays;

/**
 * MedianOfTwoSortedArrayOfSameSize
 */
public class MedianOfTwoSortedArrayOfSameSize {
    public static void main(String[] args) {
        int[] a = { 2, 6, 9, 10, 11 };
        int[] b = { 1, 5, 7, 12, 15 };

        // Naive Approach Time Complexity: O(n)
        findMedianByNaiveApproach(a, b);

        // Binary Search Time Complexity O(logn)
        double median = findMedian(a, b, 0, a.length - 1, 0, b.length - 1);
        System.out.println("Median: " + median);
    }

    public static void findMedianByNaiveApproach(int a[], int b[]) {
        int len = a.length + b.length;
        int c[] = new int[len];

        int ai = 0;
        int bi = 0;
        for (int i = 0; i < len; i++) {
            if (ai < a.length && bi < b.length) {
                if (a[ai] < b[bi]) {
                    c[i] = a[ai];
                    ai++;
                } else {
                    c[i] = b[bi];
                    bi++;
                }
            } else if (ai < a.length) {
                c[i] = a[ai];
                ai++;
            } else {
                c[i] = b[bi];
                bi++;
            }
        }
        float median = 0;
        int mid = len / 2;
        if (len % 2 != 0) {
            median = c[mid + 1];
        } else {
            float a1 = c[mid];
            float b1 = c[mid - 1];
            median = (a1 + b1) / 2;
        }
        System.out.println("Median: " + median);
    }

    public static double findMedian(int a[], int b[], int a_start, int a_end, int b_start, int b_end) {

        // for (int i = a_start; i <= a_end; i++) {
        // System.out.print(a[i] + " ");
        // }
        // System.out.println();
        // for (int i = b_start; i <= b_end; i++) {
        // System.out.print(b[i] + " ");
        // }
        // System.out.println();

        if (a_end - a_start <= 1 && b_end - b_start <= 1) {
            return (1.0 * (Math.max(a[a_start], b[b_start]) + Math.min(a[a_end], b[b_end])) / 2);
        }

        double m1 = getMedian(a, a_start, a_end);
        double m2 = getMedian(b, b_start, b_end);
        int a_mid = (a_start + a_end) / 2;
        int b_mid = (b_start + b_end) / 2;

        if (m1 == m2) {
            return m1;
        } else if (m1 > m2) {
            return findMedian(a, b, a_start, a_mid, b_mid, b_end);
        } else {
            return findMedian(a, b, a_mid, a_end, b_start, b_mid);
        }
    }

    public static double getMedian(int arr[], int start, int end) {

        int len = end - start + 1;

        int mid = (end + start) / 2;
        if (len % 2 == 0) {
            return 1.0 * (arr[mid] + arr[mid + 1]) / 2;
        } else {
            return arr[mid];
        }
    }

}