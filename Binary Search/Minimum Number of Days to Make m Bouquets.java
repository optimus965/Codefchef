class Solution {
    public int minDays(int[] nums, int m, int k) {
        long val = (long) m * k;
        int n = nums.length; // Size of the array
        if (val > n) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       
        int ans = -1;
        for(int i =0;i < nums.length;i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int low = min;
        int high = max;
        while(low <= high) {
            int mid = (low + high) >> 1;
            int count = 0;
            int continous = 0;
            for(int i =0;i < n;i++) {
                if(nums[i] <= mid) {
                    continous += 1;
                }
                else {
                    count += continous/k;
                    continous =0;
                }
            }
            count += continous/k;
            if(count < m) {
                low = mid + 1;
               
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}
