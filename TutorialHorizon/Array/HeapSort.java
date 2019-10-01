import java.util.Arrays;

/**
 * HeapSort
 *
 * 1. Min Heap Implementation
 * 
 * 2. Max Heap Implementation
 */
public class HeapSort {

    public static void main(String[] args) {
        int arrA[] = { 9, 10, 5, 3, 1, 2, 6 };

        MaxHeap maxHeap = new MaxHeap(arrA);
        maxHeap.sort();

        MinHeap minHeap = new MinHeap(arrA);
        minHeap.sort();
    }

    static class MinHeap {
        int arr[];
        int minHeap[];
        int current;

        public MinHeap(int arr[]) {
            this.arr = arr;
            minHeap = new int[arr.length + 1];
            current = 0;

            for (int i = 0; i < arr.length; i++) {
                addItem(arr[i]);
            }
        }

        public void addItem(int num) {
            if (current + 1 == minHeap.length) {
                System.out.println("Min Heap is full");
                return;
            }

            current++;
            minHeap[current] = num;

            int curr = current;
            int parent = curr / 2;
            while (parent > 0 && minHeap[parent] > minHeap[curr]) {
                int temp = minHeap[curr];
                minHeap[curr] = minHeap[parent];
                minHeap[parent] = temp;

                curr = parent;
                parent = curr / 2;
            }
        }

        public int extractMin() {

            if (current < 1) {
                System.out.println("Heap is empty");
                return 0;
            }

            int min = minHeap[1];

            minHeap[1] = minHeap[current];
            minHeap[current] = 0;
            current--;

            heapify(1);

            return min;
        }

        public void heapify(int pos) {
            int left = pos * 2;
            int right = pos * 2 + 1;

            if (left > current) {
                return;
            }

            int newPos = pos;
            if (minHeap[left] < minHeap[newPos]) {
                newPos = left;
            }

            if (right <= current && minHeap[right] < minHeap[newPos]) {
                newPos = right;
            }

            if (pos != newPos) {
                int temp = minHeap[newPos];
                minHeap[newPos] = minHeap[pos];
                minHeap[pos] = temp;
                heapify(newPos);
            }
        }

        public void sort() {
            System.out.println("Ascending Sorting: ");
            int i = 1;
            while (i < minHeap.length) {
                int num = extractMin();
                i++;
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    static class MaxHeap {
        int arr[];
        int maxHeap[];
        int current;

        public MaxHeap(int arr[]) {
            this.arr = arr;
            maxHeap = new int[arr.length + 1];
            current = 0;
            for (int i = 0; i < arr.length; i++) {
                addItem(arr[i]);
            }

            System.out.println(Arrays.toString(maxHeap));
        }

        public void addItem(int num) {
            if ((current + 1) == maxHeap.length) {
                System.out.println("Heap is full.");
                return;
            }

            current++;
            maxHeap[current] = num;
            int curr = current;
            int parent = curr / 2;
            while (parent > 0 && maxHeap[parent] < maxHeap[curr]) {
                int temp = maxHeap[parent];
                maxHeap[parent] = maxHeap[curr];
                maxHeap[curr] = temp;
                curr = parent;
            }
        }

        public void heapify(int curr) {
            int left = curr * 2;
            int right = curr * 2 + 1;

            if (left > current) {
                return;
            }

            int pos = curr;
            if (maxHeap[left] > maxHeap[pos]) {
                pos = left;
            }

            if (maxHeap[right] > maxHeap[pos]) {
                pos = right;
            }

            if (pos != curr) {
                int temp = maxHeap[pos];
                maxHeap[pos] = maxHeap[curr];
                maxHeap[curr] = temp;
                heapify(pos);
            }
        }

        public int extractMax() {

            if (current < 1) {
                System.out.println("Heap is empty");
                return -1;
            }

            int max = maxHeap[1];
            maxHeap[1] = maxHeap[current];
            maxHeap[current] = 0;
            current--;
            heapify(1);
            return max;
        }

        public void sort() {
            System.out.println("Descending Order: ");
            int i = 1;
            while (i < maxHeap.length) {
                int item = extractMax();
                System.out.print(item + " ");
                i++;
            }
            System.out.println();
        }

    }

}