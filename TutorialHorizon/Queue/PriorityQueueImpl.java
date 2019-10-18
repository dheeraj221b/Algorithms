import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueueImpl
 */
public class PriorityQueueImpl {

    public static void main(String[] args) {
        int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };

        System.out.println("Min Heap Impl: ");
        implementMinHeapPriorityQueue(arrA);

        System.out.println("Max Heap Impl: ");
        implementMaxHeapPriorityQueue(arrA);
    }

    // Need to provide comparator
    public static void implementMaxHeapPriorityQueue(int arr[]) {
        PriorityQueue queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();

    }

    // By Default implementation is MinHeap
    public static void implementMinHeapPriorityQueue(int arr[]) {
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

}