import java.util.ArrayList;
import java.util.List;

public class MinSumPathTriangle {
    public int minimumTotal(List<List<Integer>> t) {
        List<List<Integer>> dp = new ArrayList<>();

        for(int i=0;i<t.size();i++){
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(t.get(0).get(0));

        for(int i=1;i<t.size();i++){
            for(int j=0;j<=i;j++){
                int lef = j-1>=0?dp.get(i-1).get(j-1):Integer.MAX_VALUE;
                int rig = j!=i?dp.get(i-1).get(j):Integer.MAX_VALUE;
                dp.get(i).add(t.get(i).get(j)+Math.min(lef,rig));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int k:dp.get(dp.size()-1))ans = k<ans?k:ans;
        return ans;
    }
}
/*Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10


Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 */