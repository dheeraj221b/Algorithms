import java.util.HashMap;

/**
 * LRUCacheImpl
 */
public class LRUCacheImpl {

    public static HashMap<Integer, Node> cache;
    public static Node head, tail;
    public static int capacity;

    public static void main(String[] args) {
        cache = new HashMap<>();
        capacity = 4;

        look(1);
        look(2);
        look(1);
        look(3);
        look(4);
        look(3);
        look(5);
        look(4);
        look(6);
    }

    public static void addToHead(Node node) {
        if (cache.size() == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public static void deleteNode(Node node) {
        if (node == head) {
            head = node.next;
        }

        if (node == tail) {
            tail = node.prev;
        }

        if (node.prev != null)
            node.prev.next = node.next;

        if (node.next != null)
            node.next.prev = node.prev;

    }

    public static void look(int data) {
        if (cache.containsKey(data)) {
            Node node = cache.get(data);
            deleteNode(node);
        } else {
            if (cache.size() == capacity) {
                int tailKey = tail.data;
                deleteNode(tail);
                cache.remove(tailKey);
            }
        }

        // Add it to the cache
        Node node = new Node(data);
        addToHead(node);
        cache.put(data, node);
        printCache();
    }

    public static void printCache() {
        if (cache.isEmpty()) {
            System.out.println("Cache is empty");
            return;
        }
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
        System.out.println();
    }

    static class Node {
        Node prev, next;
        int data;

        public Node(int data) {
            this.data = data;
            prev = next = null;
        }

    }
}