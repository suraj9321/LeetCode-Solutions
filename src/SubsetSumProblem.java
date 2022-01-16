public class SubsetSumProblem {
    public int solve(int[] A, int B) {
        boolean dp[][] = new boolean[A.length+1][B+1];

        for(int i=0;i<=A.length;i++)dp[i][0]=true;

        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B;j++){

                if(A[i-1]>j){dp[i][j]=dp[i-1][j];}
                else{
                    dp[i][j] = dp[i-1][j-A[i-1]]||dp[i-1][j];
                }
            }
        }

        return dp[A.length][B]==true?1:0;
    }
}

/*Problem Description

Given an integer array A  of size N.

You are also given an integer B, you need to find whether their exist a subset in A whose sum equal B.

If there exist a subset then return 1 else return 0.



Problem Constraints
1 <= N <= 100

1 <= A[i] <= 100

1 <= B <= 105



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return 1 if there exist a subset with sum B else return 0.



Example Input
Input 1:

 A = [3, 34, 4, 12, 5, 2]
 B = 9
Input 2:

 A = [3, 34, 4, 12, 5, 2]
 B = 30


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 There is a subset (4, 5) with sum 9.
Explanation 2:

 There is no subset that add up to 30.*/
