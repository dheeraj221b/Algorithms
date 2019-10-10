
/**
 * FindRepeatingCharacter
 */
public class FindRepeatingCharacter {
    public static void main(String[] args) {
        int arr[] = new int[26];

        String input = "algorithms tutorials";
        // String input = "horizon tutorials";
        // String input = "algorithms";
        // String input = "aabbccdd";

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
        findLastNonRepeatingCharacter(input, arr);
        findLastRepeatingCharacter(input, arr);
    }

    public static void findLastRepeatingCharacter(String s, int arr[]) {
        char lastNRC = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (arr[(int) ch - 97] == -1) {
                lastNRC = ch;
                break;
            }
        }

        if (lastNRC == ' ') {
            System.out.println("There is no Last repeating character in string.");
        } else {
            System.out.println("Last Repeating Character is: " + lastNRC);
        }
    }

    public static void findLastNonRepeatingCharacter(String s, int arr[]) {
        char lastNRC = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (arr[(int) ch - 97] == 1) {
                lastNRC = ch;
                break;
            }
        }

        if (lastNRC == ' ') {
            System.out.println("There is no last non repeating character in string.");
        } else {
            System.out.println("Last non repeating character is: " + lastNRC);
        }
    }

}