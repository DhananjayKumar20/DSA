package SlidingWindowPattern;

public class MaxSumSubarray {

	public static void main(String[] args) 
    {
        
        int[] arr = {100, 200, 300, 400}; 
        int k = 2; // window size
        
        int low = 0;
        int high = k - 1;
        int sum = 0;

        for (int i = low; i <= high; i++) 
        {
            sum = sum + arr[i];
        } 
        
        int res = sum;
        int n = arr.length;

        while (high < n) 
        {
            res = Math.max(res, sum);
            
            low++;
            high++;
            
            if (high == n) {
                break;
            }
            sum = sum - arr[low - 1];
            sum = sum + arr[high];
        }
        System.out.println(res);
    }
}
