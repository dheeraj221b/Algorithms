import java.util.Stack;

/**
 * ReverseStackUsingRecursionWithoutUsingExtraMemory
 * 
 * Objective: Given a Stack, write an algorithm to reverse the stack.
 * 
 * Example:
 * 
 * Original Stack: [14, 9, 67, 91, 101, 25] Reversed Stack: [25, 101, 91, 67, 9,
 * 14]
 */
public class ReverseStackUsingRecursionWithoutUsingExtraMemory {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(14);
        stack.add(9);
        stack.add(67);
        stack.add(91);
        stack.add(101);
        stack.add(25);

        System.out.println("Before Reverse: " + stack);
        reverseStack(stack);
        System.out.println("After Reverse: " + stack);
    }

    public static void reverseStack(Stack stack) {
        if (stack.size() > 0) {
            int x = (int) stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, x);
        }
    }

    public static void insertAtBottom(Stack stack, int x) {
        if (stack.size() == 0) {
            stack.add(x);
            return;
        }
        int y = (int) stack.pop();
        insertAtBottom(stack, x);

        stack.push(y);
    }
}