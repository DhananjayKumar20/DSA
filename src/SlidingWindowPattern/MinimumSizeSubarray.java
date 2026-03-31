package SlidingWindowPattern;

public class MinimumSizeSubarray {

	public static void main(String[] args) {

        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        int low = 0, high = 0;
        int sum = 0;

        int res = Integer.MAX_VALUE;
        int n = nums.length;

        while (high < n) {
        	
            sum = sum + nums[high];

            while (sum >= target) {
                int len = high - low + 1;
                res = Math.min(res, len);

                sum = sum - nums[low];
                low++;
            }
            high++;
        }

        int result = (res == Integer.MAX_VALUE) ? 0 : res;
        System.out.println(result);
    }
}
