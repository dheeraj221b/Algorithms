/**
 * SortedArrayToBinarySearchTreeMinimalHeight
 */
public class SortedArrayToBinarySearchTreeMinimalHeight {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr = { 2, 3, 6, 7, 8, 9, 12, 15, 16, 18, 20 };
        Node rootNode = createMinimalHeightBST(arr, 0, arr.length - 1);
        displayTree(rootNode);
        System.out.println();
    }

    public static Node createMinimalHeightBST(int arr[], int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;

        Node root = new Node(arr[mid]);
        root.left = createMinimalHeightBST(arr, low, mid - 1);
        root.right = createMinimalHeightBST(arr, mid + 1, high);

        return root;

    }

    public static void displayTree(Node rootNode) {
        if (rootNode != null) {
            displayTree(rootNode.left);
            System.out.print(rootNode.data + " ");
            displayTree(rootNode.right);
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}