
class Solution {
    public boolean canCross(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        Map<Integer,Integer> map = new HashMap<>();
        int max =0;
        for(int i = 0;i < stones.length;i++) {
            map.put(stones[i],i);
            max = Math.max(max,stones[i]);
        }
        int value = stones[0];
        boolean k_1 = dp(stones,1,stones[0],dp,map,max,true);
        // boolean k_3 = dp(stones,1,stones[0], dp, map,max);
        return k_1;
    }
    // at each step there are 3 possible ways
    public boolean dp(int[] stone,int k,int position,Boolean[][] dp,Map<Integer,Integer> map,int max,boolean start) {
        if(position == max) {
            return true;
        }
        if(k <= 0 || position > max) {
            return false;
        }
        if(map.containsKey(position)) {
//            System.out.println("Hello, world");
            int i = map.get(position);
           if(dp[i][k] != null) {
               return dp[i][k];
           }
            boolean k_1 = dp(stone,k,position + k,dp,map,max,false);
            boolean k_2 = dp(stone,k -1,position + k - 1,dp,map,max,false);
            boolean k_3 = false;
            if(start ==false) {
                k_3 = dp(stone,k + 1,position + k + 1, dp, map,max,false);
            }
           
            dp[i][k] = (k_1 || k_2 || k_3);
            boolean cv = dp[i][k];
            return cv;
        }
        return false;
    }
}
