import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] string = reader.readLine().split(" ");
        for(int i =0;i < n;i++) {
            nums[i] = Integer.parseInt(string[i]);
        }
        solution sol = new solution();
        Boolean[][] dp = sol.sol(nums);
        int[] count = new int[nums.length];
        for(int i =0;i < n;i++) {
//            System.out.println(i);
            if(dp[0][i]) {
                count[i] = 1;
            }
            else {
                count[i] = (int)1e8 +2;
                for(int j = 0;j < i;j++) {
                    if(dp[j + 1][i]) {
                        count[i] = Math.min(count[i],count[j] + 1);
                    }
                }
            }
        }
        System.out.println(count[n - 1]);
    }
}
class solution {
    Boolean[][] dp;
    public Boolean[][] sol(int[] nums) {
        dp = new Boolean[nums.length][nums.length];
        for(int i =0;i < nums.length;i++) {
            dp[i][i] = true;
        }
        dp(nums,dp,0, nums.length - 1);
        return dp;
    }

  // memoization
    public boolean dp(int[] nums,Boolean[][] dp,int start,int end) {
        if(start == end) {
            return true;
        }
        if(start > end) {
            return true;
        }
        if(dp[start][end] != null) {
            return dp[start][end];
        }
        if(nums[start] == nums[end] && dp(nums,dp,start + 1,end - 1)) {
            dp[start][end] = true;
        }
        else {
            dp[start][end] = false;

        } dp(nums,dp,start + 1,end);
        dp(nums,dp,start,end - 1);
        return dp[start][end];
    }
}
