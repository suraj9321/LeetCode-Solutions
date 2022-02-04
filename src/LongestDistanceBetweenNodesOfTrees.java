import java.util.*;

public class LongestDistanceBetweenNodesOfTrees {
    private int ans =0;
    LinkedList<Integer> gp[];
    private boolean visited[];
    private int dfs(int root){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        pq.add(0);
        for(int i=0;i<gp[root].size();i++){
            if(!visited[gp[root].get(i)]){
                visited[gp[root].get(i)]=true;
                pq.add(dfs(gp[root].get(i)));
                pq.poll();
            }
        }
        int len1 =  pq.poll() ;
        int len2 =  pq.poll();
        len1+=len2;
        if(len1>ans)ans = len1;
        return len2+1;

    }

    public int solve(ArrayList<Integer> A) {
        gp = new LinkedList[A.size()];
        visited = new boolean[A.size()];
        for(int i=0;i<A.size();i++){
            gp[i] = new LinkedList<>();
        }
        int root=0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)==-1){
                root=i;
                continue;
            }
            gp[i].add(A.get(i));
            gp[A.get(i)].add(i);
        }
        visited[root]=true;
        dfs(root);
        return ans;

    }
}
/*Problem Description

Given an arbitrary unweighted rooted tree which consists of N nodes.

The goal of the problem is to find largest distance between two nodes in a tree.

Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints
1 <= N <= 40000



Input Format
First and only argument is an integer array A of size N.



Output Format
Return a single integer denoting the largest distance between two nodes in a tree.



Example Input
Input 1:

 A = [-1, 0, 0, 0, 3]


Example Output
Output 1:

 3


Example Explanation
Explanation 1:

 node 0 is the root and the whole tree looks like this:
          0
       /  |  \
      1   2   3
               \
                4

 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3.

*/