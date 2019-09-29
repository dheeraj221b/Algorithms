import java.util.Stack;

/**
 * TrackMaxInStack
 */
public class TrackMaxInStack {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 14, 1, 18 };

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> trackStack = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            stack.add(num);

            if (trackStack.size() > 0) {
                int top = trackStack.peek();
                if (num > top) {
                    trackStack.add(num);
                } else {
                    trackStack.add(top);
                }
            } else {
                trackStack.add(num);
            }
        }

        System.out.println("Max Element: " + trackStack.peek());
        int item = stack.pop();
        trackStack.pop();
        System.out.println("Item Removed: " + item);
        System.out.println("Now Max Element: " + trackStack.peek());
    }
}