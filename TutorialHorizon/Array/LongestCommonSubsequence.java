/**
 * LongestCommonSubsequence
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "acbaed";
        String s2 = "abcadf";

        int arr[][] = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                arr[i][0] = 1;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(0) == s2.charAt(i)) {
                arr[0][1] = 1;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        System.out.println("Max Subsequence length: " + arr[s1.length() - 1][s2.length() - 1]);
    }
}