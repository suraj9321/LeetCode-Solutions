import java.util.*;

public class PossibilityFinishPreRequisiteAllCourses {
    boolean visited[];
    LinkedList<Integer> gp[];
    public boolean dfsCycle(int v,boolean vis_path[]){
        for(int i=0;i<gp[v].size();i++){
            if(vis_path[gp[v].get(i)])return true;
            visited[gp[v].get(i)]=true;
            vis_path[gp[v].get(i)]=true;
            if(dfsCycle(gp[v].get(i),vis_path))return true;
            vis_path[gp[v].get(i)]=false;
        }
        return false;
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        visited = new boolean[A];
        gp = new LinkedList[A];
        for(int i=0;i<A;i++)gp[i] = new LinkedList<>();
        for(int i=0;i<B.size();i++){
            gp[B.get(i)-1].add(C.get(i)-1);
        }
        boolean vis_path[] = new boolean[A];
        for(int i=0;i<A;i++){
            if(!visited[i]){
                visited[i]=true;
                vis_path[i] =true;
                if(dfsCycle(i,vis_path))return 0;
                vis_path[i] = false;
            }
        }
        return 1;
    }
}
/*There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
The pairs are given as two arrays B and C, where [B[i], C[i]] form a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.


Problem Constraints
1 <= A <= 64
1 <= length(B) = length(C) <= 1e5
1 <= B[i], C[i] <= A


Input Format
The first argument of input contains an integer A, representing the number of courses.
The second argument of input contains an integer array, B.
The third argument of input contains an integer array, C.


Output Format
Return a boolean value:
1 : If it is possible to complete all the courses.
0 : If it is not possible to complete all the courses.


Example Input
Input 1:
A = 3
B = [1, 2]
C = [2, 3]
Input 2:

A = 2
B = [1, 2]
C = [2, 1]


Example Output
Output 1:
1
Output 2:

0


Example Explanation
Explanation 1:
It is possible to complete the courses in the following order:
1 -> 2 -> 3
Explanation 2:

It is not possible to complete all the courses.

*/