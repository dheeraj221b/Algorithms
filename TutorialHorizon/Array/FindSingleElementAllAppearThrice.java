/**
 * FindSingleElementAllAppearThrice
 */
public class FindSingleElementAllAppearThrice {
    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 2, 4, 2, 5, 6, 3, 3, 6, 5, 2 };
        int num = 0;
        for (int j = 0; j < 32; j++) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & 1 << j) > 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                num = num | 1 << j;
            }
        }
        System.out.println(num);
    }
}