import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while(testCases-->0) {
            int n = Integer.parseInt(reader.readLine());
            String[] string = reader.readLine().split(" ");
            int[] nums = new int[string.length];
            for(int i =0;i < string.length;i++) {
                nums[i] = Integer.parseInt(string[i]);
            }
            int[] dp = new int[n];
            int[] dp1 = new int[n];
            for(int i = 1;i < n;i++) {
                int j = i - 1;
                while(j>= 0 && nums[j] < nums[i]) {
                    j--;
                }
                if(j < 0) {
                    dp[i] = 0;
                }
                else {
                    if(nums[j] == nums[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            for(int i = n - 2;i >= 0;i--) {
                int j = i  + 1;
                while(j< n && nums[j] < nums[i]) {
                    j++;
                }
                if(j == n) {
                    dp1[i] = 0;
                }
                else {
                    if(nums[j] == nums[i]) {
                        dp1[i] = dp1[j] + 1;
                    }
                }
            }
            nums = new int[n];
            for(int i =0;i < n;i++) {
                nums[i] = dp[i] + dp1[i];
                System.out.print(nums[i] + " ");
            }
        }
    }
}
