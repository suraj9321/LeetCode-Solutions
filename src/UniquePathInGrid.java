public class UniquePathInGrid {
    public int uniquePathsWithObstacles(int[][] A) {
        if(A[0][0]==1)return 0;
        int dp[][] = new int[A.length][A[0].length];
        dp[0][0]=1;
        for(int i=1;i<A.length;i++){
            if(A[i][0]==1)break;
            dp[i][0]=1;
        }
        for(int i=1;i<A[0].length;i++){
            if(A[0][i]==1)break;
            dp[0][i]=1;
        }

        for(int i=1;i<A.length;i++){
            for(int j=1;j<A[0].length;j++){

                dp[i][j]= A[i][j]==0?dp[i-1][j]+dp[i][j-1]:0;
            }
        }
        return dp[A.length-1][A[0].length-1];
    }
}
/*Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.*/