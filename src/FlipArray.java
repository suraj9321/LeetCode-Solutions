public class FlipArray {
    public int solve(final int[] A) {
        int sum =0;
        for(int i:A)sum+=i;

        int half = sum/2;

        // int dp[][] = new int[A.length+1][half+1];

        // for(int i=1;i<=A.length;i++){
        //     for(int j=1;j<=half;j++){
        //         if(A[i-1]>j)dp[i][j] = dp[i-1][j];
        //         else{
        //             dp[i][j] = Math.max(dp[i-1][j],A[i-1]+dp[i-1][j-A[i-1]]);
        //         }
        //     }
        // }

        // int nsum = dp[A.length][half];
        int nsum = half;
        int dp2[][] = new int[A.length+1][nsum+1];

        for(int i=1;i<=nsum;i++){
            dp2[0][i] = Integer.MAX_VALUE-1;
        }

        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=nsum;j++){
                if(A[i-1]>j)dp2[i][j] = dp2[i-1][j];
                else{
                    dp2[i][j] = Math.min(dp2[i-1][j],1+dp2[i-1][j-A[i-1]]);
                }
            }
        }
        //return dp2[A.length][nsum];
        for(int i=nsum;i>=0;i--){
            if(dp2[A.length][i]!=Integer.MAX_VALUE&&dp2[A.length][i]!=Integer.MAX_VALUE-1)return dp2[A.length][i];
        }
        return 0;

    }
}
/*Given an array of  positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible). Return the minimum no. of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

Constraints:

 1 <= n <= 100
Sum of all the elements will not exceed 10,000.

Example:

A = [15, 10, 6]
ans = 1 (Here, we will flip the sign of 15 and the resultant sum will be 1 )

A = [14, 10, 4]
ans = 1 (Here, we will flip the sign of 14 and the resultant sum will be 0)

Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there are not minimum*/
