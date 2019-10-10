import java.util.Stack;

/**
 * SortStackUsingTempStack
 */
public class SortStackUsingTempStack {

    public static void main(String[] args) {
        Stack<Integer> originalStack = new Stack<>();
        originalStack.add(14);
        originalStack.add(9);
        originalStack.add(67);
        originalStack.add(91);
        originalStack.add(101);
        originalStack.add(25);

        // using recursion
        // sortStack(originalStack);

        // sorting without recursion
        sortStackWithoutRecursion(originalStack);
    }

    public static void sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int item = (int) stack.pop();
            insertIntoTempStack(tempStack, item);
        }

        System.out.println(tempStack);
    }

    public static void insertIntoTempStack(Stack<Integer> stack, int num) {

        if (stack.empty()) {
            stack.push(num);
            return;
        }

        int top = stack.peek();
        if (top > num) {
            top = stack.pop();
            insertIntoTempStack(stack, num);
            stack.push(top);
        } else {
            stack.push(num);
        }
    }

    public static void sortStackWithoutRecursion(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int top = (int) stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > top) {
                stack.push(tempStack.pop());
            }
            tempStack.push(top);
        }

        System.out.println(tempStack);

    }

}