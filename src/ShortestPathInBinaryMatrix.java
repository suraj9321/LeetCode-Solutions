import java.util.ArrayDeque;

public class ShortestPathInBinaryMatrix {

    boolean vis[][];
    int ans = -1;
    int grid[][];
    int i_mov[] = {-1,-1,-1,1,1,1,0,0};
    int j_mov[] = {0,-1,1,0,-1,1,-1,1};

    public int bfs(){
        int lvl=1;

        ArrayDeque<Integer> q  = new ArrayDeque<>();
        q.add(0);
        q.add(0);
        q.add(1);

        while(!q.isEmpty()){

            int r = q.poll();
            int c = q.poll();
            lvl = q.poll();
            if(r == grid.length-1 && c == grid[0].length-1){
                return lvl;
            }
            for(int k=0;k<8;k++){
                int r_mov = r + i_mov[k];
                int c_mov = c + j_mov[k];

                if(r_mov>=0&&r_mov<grid.length && c_mov>=0&&c_mov<grid[0].length){
                    if(!vis[r_mov][c_mov]&&grid[r_mov][c_mov]==0){
                        q.add(r_mov);
                        q.add(c_mov);
                        q.add(lvl+1);
                    }
                    vis[r_mov][c_mov]=true;
                }
            }
        }
        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0)return -1;
        vis = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        return bfs();
    }
}