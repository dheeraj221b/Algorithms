import java.util.Stack;

/**
 * TrackMaximumInStack
 */
public class TrackMaximumInStack {

    static Stack<Integer> orgStack, tempStack;

    public static void main(String[] args) {

        orgStack = new Stack<>();
        tempStack = new Stack<>();

        insertIntoStack(4);
        insertIntoStack(2);
        insertIntoStack(14);
        insertIntoStack(1);
        insertIntoStack(18);

        int max = getMax();
        System.out.println("Max: " + max);
        removeItem();
        max = getMax();
        System.out.println("Max: " + max);
    }

    public static void removeItem() {
        if (!orgStack.isEmpty()) {
            orgStack.pop();
            tempStack.pop();
        } else {
            System.out.println("Stack is empty");
        }
    }

    public static int getMax() {
        if (tempStack.size() > 0) {
            return tempStack.peek();
        }
        return -1;
    }

    public static void insertIntoStack(int num) {
        orgStack.add(num);

        if (tempStack.size() == 0) {
            tempStack.add(num);
            return;
        }

        if (num > tempStack.peek()) {
            tempStack.add(num);
        } else {
            tempStack.add(tempStack.peek());
        }
    }
}