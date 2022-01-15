public class MaximumPathInTriangle {
    public int solve(int[][] A) {
        int dp[][] = new int[A.length][A[0].length];
        int i=1;
        dp[0][0] = A[0][0];
        while(i<A.length){
            int j=0;
            while(j<=i){
                int opt1 = dp[i-1][j]>0?dp[i-1][j]:0;
                int opt2 = j-1>=0?dp[i-1][j-1]:0;
                dp[i][j] = A[i][j] + Math.max(opt1,opt2);
                j++;
            }
            i++;
        }
        int res=0;
        for(int k=0;k<A[0].length;k++){
            res = Math.max(res,dp[A.length-1][k]);
        }
        return res;

    }
}
/*
    Problem Description

    Given a 2D integer array A of size  N * N   representing a triangle of numbers.

        Find the maximum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

        NOTE:

        Adjacent cells to cell (i,j) are only (i+1,j) and (i+1,j+1)
        Row i contains i integer and n-i zeroes for all i in [1,n] where zeroes represents empty cells.


        Problem Constraints
        0 <= N <= 1000

        0 <= A[i][j] <= 1000



        Input Format
        First and only argument is an 2D integer array A of size N * N.



        Output Format
        Return a single integer denoting the maximum path sum from top to bottom in the triangle.



        Example Input
        Input 1:

        A = [
        [3, 0, 0, 0]
        [7, 4, 0, 0]
        [2, 4, 6, 0]
        [8, 5, 9, 3]
        ]
        Input 2:

        A = [
        [8, 0, 0, 0]
        [4, 4, 0, 0]
        [2, 2, 6, 0]
        [1, 1, 1, 1]
        ]


        Example Output
        Output 1:

        23
        Output 2:

        19


        Example Explanation
        Explanation 1:

        Given triangle looks like:  3
        7 4
        2 4 6
        8 5 9 3
        So max path is (3 + 7 + 4 + 9) = 23
        Explanation 1:

        Given triangle looks like:  8
        4 4
        2 2 6
        1 1 1 1
        So max path is (8 + 4 + 6 + 1) = 19
*/
