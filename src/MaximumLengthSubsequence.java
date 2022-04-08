public class MaximumLengthSubsequence {

    public int MaximumLengthSubsequence(String S, int x){
        int dp[][] = new int[S.length()][2];
        int arr[] = new int[S.length()];
        for(int i=S.length()-1;i>=0;i--){
            arr[S.length()-1-i] = S.charAt(i)-'0';

        }
        dp[0][0] = arr[0];
        dp[0][1]=1;

        for(int i=1;i<S.length();i++){
            dp[i][0] = arr[i];
            dp[i][1]=1;
            for(int j=0;j<i;j++){
                if(((1+dp[j][1])>=dp[i][1])&&(((int)Math.pow(2,dp[j][1])*arr[i])+dp[j][0]<=x)){
                    dp[i][0] = ((int)Math.pow(2,dp[j][1])*arr[i])+dp[j][0];
                    dp[i][1] = 1+dp[j][1];
                }
            }
        }

        int max = 1;
        for(int i=0;i<dp.length;i++){
            if(dp[i][1]>max)max = dp[i][1];
        }
        return max;
    }
}
