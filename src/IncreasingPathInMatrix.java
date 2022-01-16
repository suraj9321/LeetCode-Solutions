public class IncreasingPathInMatrix {
    public int solve(int[][] A) {
        int dp[][] = new int[A.length][A[0].length];

        int cnt=2;
        dp[0][0]=1;
        for(int i=1;i<A[0].length;i++){
            if(A[0][i]<A[0][i-1])break;
            dp[0][i]=cnt++;
        }
        cnt=2;
        for(int i=1;i<A.length;i++){
            if(A[i][0]<A[i-1][0])break;
            dp[i][0]=cnt++;
        }

        for(int i=1;i<A.length;i++){
            for(int j=1;j<A[0].length;j++){
                int lef = A[i][j]>A[i-1][j]&&dp[i-1][j]!=0?1+dp[i-1][j]:0;
                int right = A[i][j]>A[i][j-1]&&dp[i][j-1]!=0?1+dp[i][j-1]:0;
                dp[i][j] = Math.max(lef,right);
            }
        }

        return dp[A.length-1][A[0].length-1]==0?-1:dp[A.length-1][A[0].length-1];

    }
}

/*Problem Description

Given a 2D integer matrix A of size N x M.

From A[i][j] you can move to A[i+1][j], if A[i+1][j] > A[i][j], or can move to A[i][j+1] if A[i][j+1] > A[i][j].

The task is to find and output the longest path length if we start from (0, 0).

NOTE:

If there doesn't exist a path return -1.


Problem Constraints
1 <= N, M <= 103

1 <= A[i][j] <= 108



Input Format
First and only argument is an 2D integer matrix A of size N x M.



Output Format
Return a single integer denoting the length of longest path in the matrix if no such path exists return -1.



Example Input
Input 1:

 A = [  [1, 2]
        [3, 4]
     ]
Input 2:

 A = [  [1, 2, 3, 4]
        [2, 2, 3, 4]
        [3, 2, 3, 4]
        [4, 5, 6, 7]
     ]


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 Longest path is either 1 2 4 or 1 3 4.
Explanation 2:

 Longest path is 1 2 3 4 5 6 7.

*/