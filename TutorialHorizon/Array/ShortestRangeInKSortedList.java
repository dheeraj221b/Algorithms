/**
 * ShortestRangeInKSortedList
 */
public class ShortestRangeInKSortedList {

    public static HeapNode minHeap[];
    public static int currentIndex = 0;
    public static HeapNode maxHeapNode = null;
    public static int shortestRange = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] A = new int[3][];
        // A[0] = new int[] { 3, 10, 15, 24 };
        // A[1] = new int[] { 0, 1, 2, 20 };
        // A[2] = new int[] { 1, 18, 21, 30 };

        A[0] = new int[] { 4, 10, 15, 24, 26 };
        A[1] = new int[] { 0, 9, 12, 20 };
        A[2] = new int[] { 5, 18, 22, 30 };

        minHeap = new HeapNode[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            insertIntoMinHeap(A[i][0], i, 0);

            if (maxHeapNode == null) {
                maxHeapNode = new HeapNode(A[i][0], i, 0);
            } else {
                if (A[i][0] > maxHeapNode.data) {
                    maxHeapNode.data = A[i][0];
                    maxHeapNode.row = i;
                    maxHeapNode.col = 0;
                }
            }
        }

        while (currentIndex > 0) {
            HeapNode minHeapNode = extractMin();

            int data = minHeapNode.data;
            int row = minHeapNode.row;
            int col = minHeapNode.col;

            // System.out.println(maxHeapNode.data + " : " + data);

            if (maxHeapNode.data - data < shortestRange) {
                shortestRange = maxHeapNode.data - data;
            }

            System.out.println(col + 1 + " : " + A[row].length);

            if (col + 1 < A[row].length) {
                insertIntoMinHeap(A[row][col + 1], row, col + 1);
                if (A[row][col + 1] > maxHeapNode.data) {
                    maxHeapNode.data = A[row][col + 1];
                    maxHeapNode.row = row;
                    maxHeapNode.col = col + 1;
                }
            } else {
                break;
            }
        }
        System.out.println("Shortest Range is: " + shortestRange);
    }

    public static void insertIntoMinHeap(int data, int row, int col) {
        if (currentIndex + 1 == minHeap.length) {
            System.out.println("MinHeap is full");
            return;
        }
        currentIndex++;
        minHeap[currentIndex] = new HeapNode(data, row, col);
        heapify();
    }

    public static void heapify() {
        int child = currentIndex;
        int parent = child / 2;

        while (parent > 0 && minHeap[parent].data > minHeap[child].data) {
            HeapNode temp = minHeap[parent];
            minHeap[parent] = minHeap[child];
            minHeap[child] = temp;

            child = parent;
            parent = parent / 2;
        }
    }

    public static HeapNode extractMin() {
        if (currentIndex == 0) {
            System.out.println("MinHeap is empty");
            return null;
        }
        HeapNode minHeapNode = minHeap[1];
        minHeap[1] = minHeap[currentIndex];
        minHeap[currentIndex] = null;
        currentIndex--;
        bubbleDown(1);
        return minHeapNode;
    }

    public static void bubbleDown(int pos) {

        int leftChild = pos * 2;
        int rightChild = pos * 2 + 1;

        int swapPos = pos;
        if (leftChild <= currentIndex && minHeap[leftChild].data < minHeap[swapPos].data) {
            swapPos = leftChild;
        }

        if (rightChild <= currentIndex && minHeap[rightChild].data < minHeap[swapPos].data) {
            swapPos = rightChild;
        }

        if (pos != swapPos) {
            HeapNode temp = minHeap[pos];
            minHeap[pos] = minHeap[swapPos];
            minHeap[swapPos] = temp;

            bubbleDown(swapPos);
        }
    }

    static class HeapNode {
        int row;
        int data;
        int col;

        public HeapNode(int data, int row, int col) {
            this.row = row;
            this.col = col;
            this.data = data;
        }
    }
}