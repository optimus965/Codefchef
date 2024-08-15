// problem Link
// https://www.naukri.com/code360/problems/allocate-books_1090540

import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m > n) {
            return -1;
        }
        int sum = 0;
        int ans = -1;
        int[] nums = new int[arr.size()];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.size();i++) {
            nums[i] = arr.get(i);
            sum = sum + nums[i];
            max = Math.max(max,nums[i]);
        }
        int low = max;
        int high = sum;
        sum =0;
        while(low <= high) {
            int mid = (low + high)/2;
            int count = 0;
            sum =0;
            for(int i = 0;i < n;i++) {
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
             if(sum <= mid) {
                    count= count + 1;
            }
            if(count <= m) {
                   high = mid - 1;
                    ans = mid;
            }
            else {
               low = mid + 1;
            }
        }
        return ans;
    }
}
