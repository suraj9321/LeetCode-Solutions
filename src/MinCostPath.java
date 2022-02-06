import java.util.*;

public class MinCostPath {
    int dp[][];
    boolean visited[][];
    ArrayList<String> C;
    int A;
    int B;

    private boolean isValidRange(int i,int j){
        return (i>=0&&i<A&&j>=0&&j<B);
    }

    private void bfs(){
        int i_mov[] = {0,0,-1,1};
        int j_mov[] = {1,-1,0,0};

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(0);
        q.add(0);
        visited[0][0]=true;
        while(q.size()!=0){
            int i = q.poll();
            int j = q.poll();
            for(int k=0;k<i_mov.length;k++){
                int i_new = i + i_mov[k];
                int j_new = j + j_mov[k];
                int temp=0;
                if(isValidRange(i_new,j_new)){

                    switch(k){
                        case 0:
                            if(C.get(i).charAt(j)=='R'){
                                temp = dp[i][j];

                            }else{

                                temp = 1+ dp[i][j];
                            }
                            break;
                        case 1:
                            if(C.get(i).charAt(j)=='L'){
                                temp = dp[i][j];
                            }else{
                                temp = 1+ dp[i][j];
                            }
                            break;
                        case 2:
                            if(C.get(i).charAt(j)=='U'){
                                temp = dp[i][j];
                            }else{
                                temp = 1+ dp[i][j];
                            }
                            break;
                        case 3:
                            if(C.get(i).charAt(j)=='D'){
                                temp = dp[i][j];
                            }else{
                                temp = 1+ dp[i][j];
                            }
                    }

                    if(!visited[i_new][j_new]||visited[i_new][j_new]&&temp<dp[i_new][j_new]){
                        dp[i_new][j_new]=temp;
                        q.add(i_new);
                        q.add(j_new);
                        visited[i_new][j_new]=true;
                    }
                }
            }
        }

    }

    public int solve(int A, int B, ArrayList<String> C) {
        dp = new int[A][B];
        this.visited = new boolean[A][B];
        this.C = C;
        this.A=A;
        this.B=B;
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0]=0;
        bfs();

        return dp[A-1][B-1];
    }
}
/*Problem Description

You are given a AB character matrix named C. Every cell in C has a character U,R,L or D indicating up,right,left and down.

Your target is to go from top left corner to the bottom right corner of the matrix.

But there are some restrictions while moving along the matrix:

If you follow what is written in the cell then you can move freely.
But if you don't follow what is written in the cell then you have to pay 1 unit of cost.
Like: If a cell contains character U and you go right instead of Up you have to pay 1 unit of cost.

So your task is to find the minimum cost to go from top-left corner to the bottom-right corner.



Problem Constraints
1 <= A,B <= 103
C[i][j] can be either U,R,L or D.


Input Format
First Argument represents a integer A (number of rows).
Second Argument represents a integer B (number of columns).
Third Argument represents a string array C which contains A strings each of length B.


Output Format
 Return an integer denoting the minimum cost to travel from top-left corner to bottom-right corner.



Example Input
Input:1

 A = 3
 B = 3
 C = ["RRR","DDD","UUU"]
Input:2

 A = 1
 B = 4
 C = ["LLLL"]


Example Output
Output-1 :

 1
Output-2 :

 3


Example Explanation*
Explanation for Input-1:

 Matrix looks like: RRR
                    DDD
                    UUU
 We go right two times and down two times.
 So from top-right cell we are going down though right is given so this incurs a cost of 1.
Explanation for Input-2:

 Matrix looks like: LLLL
 We go right three times.


*/