public class WordSearch {
    private char[][] A;
    private String B;
    private int mov_i[] = {0,0,1,-1};
    private int mov_j[] = {1,-1,0,0};
    private boolean visited[][];

    private boolean isValid(int i, int j){
        return i>=0&&i<A.length&&j>=0&&j<A[0].length;
    }
    public boolean dfs(int i, int j, int k){
        if(k==B.length()-1&&A[i][j]==B.charAt(k))return true;

        for(int a=0;a<4;a++){
            int new_i = i + mov_i[a];
            int new_j = j + mov_j[a];
            if(isValid(new_i,new_j)&&!visited[new_i][new_j]){
                if(A[new_i][new_j]==B.charAt(k+1)){
                    visited[new_i][new_j]=true;
                    if(dfs(new_i,new_j,k+1))return true;
                    visited[new_i][new_j]=false;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] A, String B) {
        this.A = A;
        this.B = B;
        visited = new boolean[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==B.charAt(0)){
                    visited[i][j]=true;
                    if(dfs(i,j,0))return true;
                    visited[i][j]=false;
                }
            }
        }
        return false;

    }
}
/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/