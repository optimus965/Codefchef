
// Chef Po has given an online advertisement to provide Event organizing services. Chef got a huge response for his advertisement. 
//   He got various orders to conduct the events from different organizations. 
//   In turn, Chef will receive a compensation depend upon the type of event and the total numbers of persons in the event. 
//   Chef has received N orders for conducting events in this weekend in all. As weekend consists of two days all events will take place during the period of 48 hours.
//   For the i-th order the corresponding event will start at Si hours, ends at Ei hours and Chef will receive a compensation Ci for this event. 
//   For example, if Si = 17 and Ei = 22 then duration of event is 22 – 17 = 5 hours and its time period is 17:00 – 22:00 of Saturday. 
//   Hours of Sunday are numbered by numbers from 24 to 48. So, for example, 10:00 of Sunday will be represented as 10 + 24 = 34. 
//   Because Chef is a newbie, the organizations had put a condition that Chef will receive a compensation for the event
//   if and only if he is available for the entire duration of the event. It means that he can not choose overlapping events.
//   Note, however, that if some event starts just in the moment another event has finished the Chef can safely conduct them both.

// test cases
//   2
// 4
// 1 2 100
// 2 3 200
// 3 4 1600
// 1 3 2100
// 3
// 1 10 2000
// 2 5 100
// 6 9 400
//   output: 3700
//           2000


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
            int n = Integer.parseInt(reader.readLine());
            int[][] dp = new int[49][49];
            long[] max = new long[49];
            int max1 = 0;
            for(int i =0;i < n;i++) {
                String[] string = reader.readLine().split(" ");
                int start  = Integer.parseInt(string[0]);
                int end = Integer.parseInt(string[1]);
                max1 = Math.max(max1,end);
                int value = Integer.parseInt(string[2]);
                dp[start][end] = Math.max(dp[start][end],value);
                max[end] = Math.max(max[end],value);
            }
            for(int end = 1;end <= 48;end++) {
                for(int start = 0;start <= end - 1;start++) {
                    max[end] = Math.max(max[start] + dp[start][end],max[end]);
                }
            }
            System.out.println(max[max1]);
        }

	}
}
