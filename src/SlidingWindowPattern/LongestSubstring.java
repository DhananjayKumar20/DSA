package SlidingWindowPattern;
import java.util.*;

public class LongestSubstring {
public static void main(String[] args) {
        
        String s = "aabacbebebe";
        int k = 3;
        
        int low = 0, high = 0;
        int res = -1;
        
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        
        while (high < n) {
            
            // expand window
            char ch = s.charAt(high);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            // shrink if distinct > k
            while (freq.size() > k) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);
                
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                low++;
            }
            
            // update result
            if (freq.size() == k) {
                res = Math.max(res, high - low + 1);
            }
            
            high++;
        }   
        System.out.println(res);  // Output: 7
    }
}
