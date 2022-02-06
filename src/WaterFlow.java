import java.util.*;

public class WaterFlow {
    int dp[][];
    ArrayList<ArrayList<Integer>> A;

    private boolean isValid(int i,int j){
        return (i>=0&&j>=0&&i<A.size()&&j<A.get(0).size());
    }

    private void bfs(int x, int y,char side){
        int i_mov[]={1,0,-1,0};
        int j_mov[]={0,1,0,-1};
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(x);
        q.add(y);
        while(q.size()!=0){
            int i=q.poll();
            int j=q.poll();
            for(int k=0;k<4;k++){
                int i_new = i+ i_mov[k];
                int j_new = j+ j_mov[k];
                if(isValid(i_new,j_new)){
                    if(side=='B'){
                        if(dp[i_new][j_new]==0&&A.get(i_new).get(j_new)>=A.get(i).get(j)){
                            dp[i_new][j_new]=1;
                            q.add(i_new);
                            q.add(j_new);
                        }
                    }
                    else{
                        if(dp[i_new][j_new]==0&&A.get(i_new).get(j_new)>=A.get(i).get(j)){
                            dp[i_new][j_new]=2;
                            q.add(i_new);
                            q.add(j_new);
                        }
                        else if(dp[i_new][j_new]==1&&A.get(i_new).get(j_new)>=A.get(i).get(j)){
                            dp[i_new][j_new]=3;
                            q.add(i_new);
                            q.add(j_new);
                        }

                    }
                }
            }

        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        dp = new int[A.size()][A.get(0).size()];
        this.A = A;
        for(int i=0;i<A.size();i++){
            if(dp[i][0]==0){
                dp[i][0]=1;
                bfs(i,0,'B');
            }
        }
        for(int i=0;i<A.get(0).size();i++){
            if(dp[0][i]==0){
                dp[0][i]=1;
                bfs(0,i,'B');
            }
        }
        for(int i=0;i<A.size();i++){
            if(dp[i][A.get(0).size()-1]==0||dp[i][A.get(0).size()-1]==1){
                dp[i][A.get(0).size()-1]=dp[i][A.get(0).size()-1]==1?3:2;
                bfs(i,A.get(0).size()-1,'R');
            }
        }
        for(int i=0;i<A.get(0).size();i++){
            if(dp[A.size()-1][i]==0 ||dp[A.size()-1][i]==1){
                dp[A.size()-1][i]=dp[A.size()-1][i]==1?3:2;
                bfs(A.size()-1,i,'R');
            }
        }

        int res =0 ;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(dp[i][j]==3)res++;
            }
        }
        return res;

    }
}

/*Problem Description

Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent, the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the number of cells from where water can flow to both the Blue and Red lake.



Problem Constraints
1 <= M, N <= 1000

1 <= A[i][j] <= 109



Input Format
First and only argument is a 2D matrix A.



Output Format
Return an integer denoting the number of cells from where water can flow to both the Blue and Red lake.



Example Input
Input 1:

 A = [
       [1, 2, 2, 3, 5]
       [3, 2, 3, 4, 4]
       [2, 4, 5, 3, 1]
       [6, 7, 1, 4, 5]
       [5, 1, 1, 2, 4]
     ]
Input 2:

 A = [
       [2, 2]
       [2, 2]
     ]


Example Output
Output 1:

 7
Output 2:

 4


Example Explanation
Explanation 1:

 Blue Lake ~   ~   ~   ~   ~
        ~  1   2   2   3  (5) *
        ~  3   2   3  (4) (4) *
        ~  2   4  (5)  3   1  *
        ~ (6) (7)  1   4   5  *
        ~ (5)  1   1   2   4  *
           *   *   *   *   * Red Lake
 Water can flow to both lakes from the cells denoted in parentheses.

Explanation 2:

 Water can flow from all cells.*/