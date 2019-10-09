/**
 * LongestCommonSubstringDP
 */
public class LongestCommonSubstringDP {

    public static void main(String[] args) {
        String s1 = "tutorialhorizon";
        String s2 = "dynamictutorialProgramming";

        // String s1 = "ABCXYZAY";
        // String s2 = "XYZABCB";

        int arr[][] = new int[s1.length()][s2.length()];

        int max = 0;
        int rowMax = 0;
        int colMax = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                arr[i][0] = 1;
            } else {
                arr[i][0] = 0;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(0)) {
                arr[0][i] = 1;
            } else {
                arr[0][i] = 0;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    } else {
                        arr[i][j] = 1;
                    }
                } else {
                    arr[i][j] = 0;
                }

                if (arr[i][j] > max) {
                    max = arr[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }
        System.out.println("Max Length: " + max);
        while (rowMax >= 0 && colMax >= 0) {
            System.out.print(s1.charAt(rowMax) + " ");
            if (rowMax >= 0) {
                rowMax--;
            }
            if (colMax >= 0) {
                colMax--;
            }
        }
        System.out.println();
    }
}