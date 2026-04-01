package SlidingWindowPattern;
import java.util.*;

public class FruitIntoBaskets {
	
    public static void main(String[] args) {
        
        int[] fruits = {1, 2, 3, 2, 2};
        int low = 0, high = 0;
        int res = 0;
        
        int n = fruits.length;
        Map<Integer, Integer> freq = new HashMap<>();
        
        while (high < n) {
            // expand window
            int fruit = fruits[high];
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
            
            // shrink if more than 2 types
            while (freq.size() > 2) {
                int leftFruit = fruits[low];
                freq.put(leftFruit, freq.get(leftFruit) - 1);
                
                if (freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit);
                }
                low++;
            }            
            // update result
            res = Math.max(res, high - low + 1);
            high++;
        }       
        System.out.println(res);  // Output: 4
    }
}
