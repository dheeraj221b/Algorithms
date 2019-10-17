import java.util.ArrayList;

/**
 * FirstRepeatingElement
 */
public class FirstRepeatingElement {

    public static void main(String[] args) {
        int[] a = { 1, 2, 5, 7, 5, 3, 10, 2 };

        int index = -1;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (list.contains(a[i])) {
                index = i;
            } else {
                list.add(a[i]);
            }
        }
        System.out.println("First repeating element is: " + a[index]);
    }
}