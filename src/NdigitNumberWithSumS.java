public class NdigitNumberWithSumS {
    public int solve(int A, int B) {
        int dp[][] = new int[A][B+1];
        for(int i=1;i<=9&&i<=B;i++){
            dp[0][i]=1;
        }
        int mod = 1000000007;
        for(int i=1;i<A;i++){
            for(int j=1;j<=B;j++){
                for(int k=0;k<=9;k++){
                    if(k<=j){
                        dp[i][j]=(dp[i-1][j-k]%mod + dp[i][j])%mod;
                    }
                }
            }
        }
        return dp[A-1][B];
    }
}
/*Find out the number of N digit numbers, whose digits on being added  equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

****

N = 2, S = 4

 Valid numbers are {22, 31, 13, 40}

 Hence output 4.*/