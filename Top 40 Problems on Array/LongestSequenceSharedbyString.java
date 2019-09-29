/**
 * LongestSequenceSharedbyString
 */
public class LongestSequenceSharedbyString {

    public static void main(String[] args) {
        String x = "Sumit Summation Summit Sum";
        // String x = "Bedroom BedClock BedTable BedWall";
        String[] arr = x.split(" ");

        String result = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            String s = arr[i];
            int len = s.length() > result.length() ? result.length() : s.length();
            String tempRes = "";
            int curr = 0;
            while (curr < len && s.charAt(curr) == result.charAt(curr)) {
                count++;
                tempRes = tempRes + s.charAt(curr);
                curr++;
            }
            result = tempRes;
        }
        System.out.println(result + " : " + count);
    }
}