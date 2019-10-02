import java.util.LinkedList;
import java.util.Queue;

/**
 * BreadthFirstSearchTreeTraversal
 * 
 * Breadth-first search (BFS) is an algorithm for traversing or searching tree
 * or graph data structures. It starts at the tree root and explores the
 * neighbor nodes first, before moving to the next level neighbors.
 */
public class BreadthFirstSearchTreeTraversal {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        levelOrderTraversal(root);
    }

}