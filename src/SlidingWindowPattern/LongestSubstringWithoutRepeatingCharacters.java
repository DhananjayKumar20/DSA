package SlidingWindowPattern;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        
        String s = "abcabcbb";
        
        Map<Character, Integer> lastIndex = new HashMap<>();
        int low = 0, high = 0, maxLength = 0;

        while (high < s.length()) {
            char ch = s.charAt(high);

            if (lastIndex.containsKey(ch)) {
                low = Math.max(low, lastIndex.get(ch) + 1);
            }

            lastIndex.put(ch, high);
            maxLength = Math.max(maxLength, high - low + 1);

            high++;
        }
        System.out.println(maxLength);  // Output: 3
    }
}