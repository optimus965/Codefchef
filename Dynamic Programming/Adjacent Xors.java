import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        while(test-->0) {
            String[] string = reader.readLine().split(" ");
            int n = Integer.parseInt(string[0]);
            int x= Integer.parseInt(string[1]);
           string = reader.readLine().split(" ");
            int[] nums = new int[n];
            for(int i =0 ;i < string.length;++i) {
                nums[i] = Integer.parseInt(string[i]);
            }
            long[][] dp = new long[n + 1][2];
            for(int i = 2;i <= n;i++) {
                long value = nums[i  - 1] + x;
                long value1 = nums[i - 2] + x;
                dp[i][1] = Math.max((value^value1) + dp[i - 1][1],(value^(nums[i - 2])) + dp[i - 1][0]);
                dp[i][0] = Math.max((nums[i - 1]^value1) + dp[i - 1][1],(nums[i - 1]^nums[i - 2]) + dp[i - 1][0]);
            }
            System.out.println(Math.max(dp[n][0],dp[n][1]));
        }
    }
}
