import java.util.*;

class BinarySearch {
    public static void main(String args[]) {
        int[] arr = { 2, 5, 8, 10, 14, 44, 77, 78, 99 };
        int num = 99;
        boolean isFound = binarySearch(arr, num, 0, arr.length - 1);
        System.out.println("Item Found: " + isFound);
        num = 76;
        isFound = binarySearch(arr, num, 0, arr.length - 1);
        System.out.println("Item Found: " + isFound);
    }

    public static boolean binarySearch(int arr[], int num, int start, int last) {

        if (last < start)
            return false;

        int mid = (start + last) / 2;

        //System.out.println(start + ":" + last + ":" + mid);

        if (arr[mid] == num)
            return true;
        else if (arr[mid] > num)
            return binarySearch(arr, num, start, mid - 1);
        else {
            return binarySearch(arr, num, mid + 1, last);
        }
    }
}