class Solution {
    private int[][] dp;
    private int[][] cost;
    //dynamic programming
    private int mcost(int hnum, int currc){
        if(hnum>cost.length-1)return 0;
        if(dp[hnum][currc]!=0)return dp[hnum][currc];
        int amt  = cost[hnum][currc]+Math.min(mcost(hnum+1,(currc+1)%3),mcost(hnum+1,(currc+2)%3));
        dp[hnum][currc] = amt;
        return amt;
    }

    public int minCost(int[][] cost) {
        this.cost = cost;
        dp = new int[cost.length][3];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            res = Math.min(res,cost[0][i]+Math.min(mcost(1,(i+1)%3),mcost(1,(i+2)%3)));
        }
        return res;
    }
}