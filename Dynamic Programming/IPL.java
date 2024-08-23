// The match fees for each match in the new season have been announced in advance. 
//   Each team has to enforce a mandatory rotation policy so that no player ever 
//   plays three matches in a row during the season.

// Nikhil is the captain and chooses the team for each match. 
// He wants to allocate a playing schedule for himself to maximize his 
// earnings through match fees during the season.
// Input:
// 5 
// 10 3 5 7 3  output:23
// Explanation: 10+3+7+3
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine().trim());
		String[] string = reader.readLine().split(" ");
		int[] nums = new int[n];
		for(int i = 0;i < n;i++) {
		    nums[i] = Integer.parseInt(string[i]);
		}
		int[][] dp = new int[n + 1][3];
		dp[1][1] = nums[0];
		for(int i = 2;i <= n;i++) {
		  dp[i][0] = Math.max(dp[i - 1][1],dp[i - 2][1]);
		  dp[i][1] = Math.max(nums[i - 1] + nums[i - 2] + dp[i - 2][0],nums[i - 1] + dp[i - 2][1]);
		}
		int max = 0;
		for(int i = n - 2;i <= n;i++) {
		    int max1 =Math.max(dp[i][0],dp[i][1]);
		    max = Math.max(max,max1);
		}
		System.out.println(max);
	}
}
