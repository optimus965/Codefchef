class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        return sol(M,n,m);
    }
    public int sol(int[][] matrix,int n,int m) {
        int[][] dp = new int[n][m];
        int maxArea = 0;
        int count = 0;
        for(int i = 0;i < n;i++) {
            dp[i][0] = matrix[i][0];
            if(dp[i][0] == 1) {
                count++;
            }
            else {
                count = 0;
            }
            maxArea = Math.max(maxArea,count);
        }
        for(int i =0;i < n;i++) {
            for(int j = 1;j < m;j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for(int k = i;k >=0;k--) {
                        width = Math.min(width,dp[k][j]);
                        maxArea = Math.max(maxArea,(i - k + 1)*width);
                    }
                   
                }
            }
        }
        return maxArea;
    }
}
