import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * GroupingOfAnagrams
 * 
 * Objective: Given an array of strings, write an algorithm to group the
 * anagrams.
 * 
 * Example:
 * 
 * Input: [rat, art, cat, act, dog, god, tar, pat] Output: [rat, art, tar] [cat,
 * act] [pat] [dog, god]
 */
public class GroupingOfAnagrams {

    public static void main(String[] args) {
        String[] input = new String[] { "rat", "art", "cat", "act", "dog", "god", "tar", "pat" };

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String s1 = String.valueOf(ch);
            if (map.containsKey(s1)) {
                map.get(s1).add(s);
            } else {
                ArrayList<String> arraylist = new ArrayList<>();
                arraylist.add(s);
                map.put(s1, arraylist);
            }
        }

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(map.get(key));
        }
    }
}