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

/*int dp[][];
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

    }*/
