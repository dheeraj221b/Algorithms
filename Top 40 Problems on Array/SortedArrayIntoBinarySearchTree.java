/**
 * SortedArrayIntoBinarySearchTree
 */
public class SortedArrayIntoBinarySearchTree {

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] arrA = { 2, 3, 6, 7, 8, 9, 12, 15, 16, 18, 20 };
        Node rootNode = createBinaryTree(arrA, 0, arrA.length - 1);
        displayBinaryTree(rootNode);
        System.out.println();
    }

    public static void displayBinaryTree(Node node) {
        if (node != null) {
            displayBinaryTree(node.left);
            System.out.print(node.data + " ");
            displayBinaryTree(node.right);
        }
    }

    public static Node createBinaryTree(int arr[], int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        // System.out.println("low: " + low + " high: " + high + " mid: " + mid);

        Node node = new Node(arr[mid]);

        node.left = createBinaryTree(arr, low, mid - 1);
        node.right = createBinaryTree(arr, mid + 1, high);

        return node;
    }

}