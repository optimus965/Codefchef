class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int sum = 0;
        int min = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++) {
            sum = sum + nums[i];
            min = Math.max(min,nums[i]);
        }
        int ans = sum;
        int low = min;
        int high = sum;
        while(low <= high) {
            int mid = (low + high) >> 1;
           sum =0;
           int count =0;
            for(int i =0;i < nums.length;i++) {
                if(sum + nums[i] > mid) {
                    if(sum <= mid) {
                        count = count + 1; 
                    }
                     sum = nums[i];
                }
                else {
                    sum = sum + nums[i];
                }
            }
           if(sum  <= mid) {
            count = count + 1;
           }
            if(count > days) {
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
