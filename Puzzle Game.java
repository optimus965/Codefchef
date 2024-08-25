// Johnny has some difficulty memorizing the small prime numbers. So, his computer science teacher has asked him to play with the following puzzle game frequently.

// The puzzle is a 3x3 board consisting of numbers from 1 to 9. The objective of the puzzle is to swap the tiles until the following final state is reached:

// 1 2 3
// 4 5 6
// 7 8 9

// At each step, Johnny may swap two adjacent tiles if their sum is a prime number. Two tiles are considered adjacent if they have a common edge.

// Help Johnny to find the shortest number of steps needed to reach the goal state.

// 2
// 7 3 2
// 4 1 5
// 6 8 9

// Output : 6

// 9 8 5
// 2 4 1
// 3 7 6


// we cant swap these tiles so that we can get to the state above mentioned so we return -1
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        solution sol = new solution();
        sol.search();
        for(int j = 0;j < 2*n;j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i =0;i < 3;i++) {
                String string = reader.readLine();
                if(string.length() < 1) {
                    break;
                }
                String[] string1 = string.split(" ");
                for(int k = 0;k < 3;k++) {
                    stringBuilder.append(string1[k]);
                }
            }
            if(!stringBuilder.isEmpty()) {
                System.out.println(sol.sol(stringBuilder.toString()));
            }
        }
	}
}

class solution {
    HashMap<String,Integer> map;
    public solution() {
        map = new HashMap<>();
    }
    public boolean check(int x1,int y1,int n) {
        return x1 >= 0 && y1 >= 0 && x1 <n && y1 < n;
    }
    public void search() {
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        String string = arrtostring(nums);
        map.put(string,1);
        Queue<String> que =new ArrayDeque<>();
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        que.add(string);
        List<Integer> list = Arrays.asList(3,5,7,11,13,17);
        HashSet<Integer> set = new HashSet<>(list);
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-->0) {
                String string1 = que.poll();
                int level = map.get(string1);
                int[][] num = stringtoarr(string1);
                for(int i = 0;i < num.length;i++) {
                    for(int j = 0;j < num.length;j++) {
                        for (int[] ints : dir) {
                            int x1 = i + ints[0];
                            int y1 = j + ints[1];
                            if (check(x1, y1, 3) && set.contains(num[i][j] + num[x1][y1])) {
                                int[][] arr = swap(i, j, x1, y1, num);
                                String string2 = arrtostring(arr);
                                if (map.containsKey(string2)) {
                                    continue;
                                }
                                map.put(string2, level + 1);
                                que.add(string2);
                            }
                        }
                    }
                }
            }
        }
    }
    public int[][] swap(int x,int y, int x1,int y1,int[][] nums) {
        int[][] copy = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i].clone();
        }
        int swap = copy[x][y];
        copy[x][y] = copy[x1][y1];
        copy[x1][y1] = swap;
        return copy;


    }
    public int sol(String s) {
        if(map.containsKey(s)) {
            return map.get(s) - 1;
        }
        return -1;
    }
    public String arrtostring(int[][] nums) {
        StringBuilder string = new StringBuilder();
        for(int i =0;i < nums.length;i++) {
            for(int j =0 ;j < nums.length;j++) {
                string.append(nums[i][j]);
            }
        }
        return string.toString();
    }
    public int[][] stringtoarr(String string) {
        int[][] nums = new int[3][3];
        int index = 0;
        for(int i =0;i < nums.length;i++) {
            for(int j = 0;j < 3;j++) {
                nums[i][j]= (string.charAt(index++) - '0');
            }
        }
        return nums;
    }
}
