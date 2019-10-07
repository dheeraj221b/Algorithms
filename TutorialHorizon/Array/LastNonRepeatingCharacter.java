import java.util.Arrays;

/**
 * LastNonRepeatingCharacter
 */
public class LastNonRepeatingCharacter {

    public static void main(String[] args) {
        int arr[] = new int[26];

        // String input = "algorithms tutorials";
        String input = "aabbccdd";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int index = (int) ch - 97;
            if (index >= 0 && index < 26) {
                if (arr[index] == 0) {
                    arr[index] = 1;
                } else {
                    arr[index] = -1;
                }

            }
        }

        boolean found = false;
        char lastNRC = ' ';
        int i = 25;

        while (i >= 0 && !found) {

            if (arr[i] == 1) {
                found = true;
                lastNRC = (char) (97 + i);
            }
            i--;
        }

        if (lastNRC == ' ') {
            System.out.println("There is no character in string which is not repeating");
        } else {
            System.out.println("Character is: " + lastNRC);
        }

    }
}