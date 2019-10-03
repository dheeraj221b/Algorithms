import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * NutsBoltsProblem
 */
public class NutsBoltsProblem {
    public static void main(String[] args) {
        char[] nuts = { '$', '%', '&', 'x', '@' };
        char[] bolts = { '%', '@', 'x', '$', '&' };

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < nuts.length; i++) {
            map.put(nuts[i], i);
        }

        for (int i = 0; i < bolts.length; i++) {
            if (map.containsKey(bolts[i])) {
                nuts[i] = bolts[i];
            } else {
                System.out.println("For bolt " + bolts[i] + " no nut is not present");
            }
        }

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}