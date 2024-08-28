import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        while(test-->0) {
            String[] string = reader.readLine().split(" ");
            int year = Integer.parseInt(string[0]);
            int k = Integer.parseInt(string[1]);
            String[] string1 = reader.readLine().split(" ");
            int[] nums = new int[string1.length];
            for(int i =0;i < nums.length;i++) {
                nums[i] = Integer.parseInt(string1[i]);
            }
            long[] prefix = new long[year];
            long[] suffix = new long[year];
            long[] cumulativePrefix = new long[year];
            long[] cumulativeSuffix = new long[year];
            cumulativePrefix[0] = nums[0];
            cumulativeSuffix[year - 1] = nums[year - 1];
            prefix[0] = nums[0];
            suffix[year - 1] = nums[year - 1];
            for(int i = 1;i < year;i++) {
                prefix[i] = Math.max(prefix[i - 1] + nums[i],nums[i]);
            }
            for(int i =1;i < year;i++) {
                cumulativePrefix[i] = Math.max(cumulativePrefix[i - 1],prefix[i]);
            }
            for(int i = year - 2;i >= 0;i--) {
                suffix[i] = Math.max(suffix[i + 1] + nums[i],nums[i]);
            }
            for(int i =year - 2;i >=0;i--) {
                cumulativeSuffix[i] = Math.max(cumulativeSuffix[i  + 1],suffix[i]);
            }
            long  max = -1000000000000007L;
            for(int i = 0;i <= year - k - 2;i++) {
                max = Math.max(max,cumulativePrefix[i] + cumulativeSuffix[i + k + 1]);
            }
            System.out.println(max);
        }
	}
}
