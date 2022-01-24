public class MergeElements {
    int A[];
    int dp[][][];
    public int[] recur(int i, int j){
        if(dp[i][j][0]!=-1){
            int ans[] = {dp[i][j][0], dp[i][j][1]};
            return ans;
        }
        int numfinal = 0;
        int costfinal = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int r1[] = recur(i,k);
            int r2[] = recur(k+1,j);
            if(r1[0]+r1[1]+r2[0]+r2[1]<costfinal){
                costfinal = r1[0]+r1[1]+r2[0]+r2[1];
                numfinal  = r1[0]+r2[0];
            }
        }
        dp[i][j][0] = numfinal;
        dp[i][j][1] = costfinal;
        int ans[] = {dp[i][j][0], dp[i][j][1]};
        return ans;
    }
    public int solve(int[] A) {
        if(A.length==1)return 0;
        this.A = A;
        dp = new int[A.length][A.length][2];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(i==j)dp[i][j][0] = A[i];
                else dp[i][j][0]=-1;
            }
        }
        int ret[] =  recur(0,A.length-1);
        return ret[1];

    }
}
/*Problem Description

Given an integer array A of size N. You have to merge all the elements of the array into one with the minimum possible cost.

The rule for merging is as follows:

Choose any two adjacent elements of the array with values say X and Y and merge them into a single element with value (X + Y) paying a total cost of (X + Y).
Return the minimum possible cost of merging all elements.



Problem Constraints
1 <= N <= 200

1 <= A[i] <= 103



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the minimum cost of merging all elements.



Example Input
Input 1:

 A = [1, 3, 7]
Input 2:

 A = [1, 2, 3, 4]


Example Output
Output 1:

 15
Output 2:

 19


Example Explanation
Explanation 1:

 All possible ways of merging:
 a) {1, 3, 7} (cost = 0) -> {4, 7} (cost = 4) -> {11} (cost = 4+11 = 15)
 b) {1, 3, 7} (cost = 0) -> {1, 10} (cost = 10) -> {11} (cost = 10+11 = 21)
 Thus, ans = 15
*/