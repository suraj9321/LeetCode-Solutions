public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        int dp[] = new int[A[0].length];
        dp[0] = Math.max(A[0][0],A[1][0]);
        if(A[0].length==1)return dp[0];
        dp[1] = Math.max(dp[0],Math.max(A[0][1],A[1][1]));

        for(int i=2;i<A[0].length;i++){
            dp[i] = Math.max(dp[i-2]+Math.max(A[0][i],A[1][i]),dp[i-1]);
        }

        return dp[A[0].length-1];

    }
}
/*Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers

is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.

Input Format:

The first and the only argument of input contains a 2d matrix, A.
Output Format:

Return an integer, representing the maximum possible sum.
Constraints:

1 <= N <= 20000
1 <= A[i] <= 2000
Example:

Input 1:
    A = [   [1]
            [2]    ]

Output 1:
    2

Explanation 1:
    We will choose 2.

Input 2:
    A = [   [1, 2, 3, 4]
            [2, 3, 4, 5]    ]

Output 2:
    We will choose 3 and 5.*/
