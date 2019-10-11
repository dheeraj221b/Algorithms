import java.util.Arrays;

/**
 * LongestIncreasingSequence
 */
public class LongestIncreasingSequence {

    public static Node headNode;
    public static int maxLength = 0;

    public static void main(String[] args) {
        int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };

        System.out.println("Solution by creating binary search tree");
        findByCreatingBST(A);
        System.out.println("Longest increasing sequence: " + maxLength);

        System.out.println("Solution using Dynamic Programming");
        findByUsingDP(A);
    }

    public static void findByUsingDP(int A[]) {
        int LIS[] = new int[A.length];
        LIS[0] = 1;
        int maxLen = 0;
        for (int i = 1; i < A.length; i++) {
            int len = -1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    len = LIS[j] + 1;
                    if (len > LIS[i]) {
                        LIS[i] = len;
                    }
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
            if (len == -1) {
                LIS[i] = 1;
            }
        }

        System.out.println("LIS using DP: " + maxLen);

        // print path
        int res = 1;
        for (int i = 0; i < A.length; i++) {
            if (LIS[i] == res) {
                System.out.print(A[i] + " ");
                res++;
            }
            if (res > maxLen) {
                break;
            }
        }
        System.out.println();
    }

    public static void findByCreatingBST(int A[]) {
        for (int i = 0; i < A.length; i++) {
            if (headNode == null) {
                headNode = new Node(A[i], 1);
            } else {
                Node tempNode = headNode;
                insertIntoBST(tempNode, A[i]);
            }
        }
    }

    public static void insertIntoBST(Node headNode, int num) {
        Node parentNode = headNode;
        while (headNode != null) {
            parentNode = headNode;
            if (headNode.data > num) {
                headNode = headNode.left;
            } else {
                headNode = headNode.right;
            }
        }

        int len = parentNode.len;
        Node node;
        if (num > parentNode.data) {
            node = new Node(num, len + 1);
            parentNode.right = node;
        } else {
            node = new Node(num, len);
            parentNode.left = node;
        }
        if (node.len > maxLength) {
            maxLength = node.len;
        }
    }

    static class Node {
        int data;
        int len;
        Node left, right;

        Node(int data, int len) {
            this.data = data;
            this.len = len;
            left = null;
            right = null;
        }
    }

}