/**
 * FindMagicIndex
 * 
 * Objective: Given a sorted array of distinct integers, Find the Magic index or
 * Fixed point in the array.
 * 
 * Magic Index or Fixed Point: Magic index or a Fixed point in an array is an
 * index i in the array such that A[i] = i.
 * 
 * Example :
 * 
 * int[] A = { -1, 0, 1, 2, 4, 10 };
 * 
 * Magic index or fixed point is : 4
 */
public class FindMagicIndex {

    public static void main(String[] args) {
        int[] A = { -1, 0, 1, 2, 4, 10 };

        int magic = findMagicIndex(A, 0, A.length);
        System.out.println("Magic Index: " + magic);
    }

    public static int findMagicIndex(int A[], int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        // System.out.println("Mid: " + mid + " A[mid]: " + A[mid]);

        if (A[mid] == mid) {
            return mid;
        } else {
            if (A[mid] < mid) {
                return findMagicIndex(A, mid + 1, end);
            } else {
                return findMagicIndex(A, start, mid - 1);
            }
        }

    }

}