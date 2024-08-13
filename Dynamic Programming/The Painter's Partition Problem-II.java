// it gives run time error because of usage of huge memory
// Java heap space

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution {
    static long minTime(int[] nums,int n,int k1){
        //code here
        long[][][] dp = new long[n + 1][n + 1][k1 + 1];
        long[] prefix = new long[n + 1];
        int min1  = Integer.MIN_VALUE;
        if(k1 >= n) {
            for(int i =0;i < nums.length;i++) {
                min1 = Math.max(min1,nums[i]);
            }
            return min1;
        }
        for(int i = 1;i <=n;i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        for(int i = 1;i <=n;i++) {
            for(int j = 1;j <= n;j++) {
                dp[i][j][1] = prefix[j] - prefix[i] + nums[i - 1];
            }
        }
        for(int i =2;i <= k1;i++) {
            for(int j =1;j <= n;j++) {
                int end = n;
                long min = Integer.MAX_VALUE;
                for(int k  = j;k < end;k++) {
                    long value = Math.max(dp[j][k][1],dp[k + 1][end][i - 1]);
                    min = Math.min(min,value);
                }
                dp[j][end][i] = min;
            }
        }
        return dp[1][n][k1];
    }
}
