import java.util.Arrays;
import java.util.Comparator;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        int ans_size = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >end ){
                intervals[ans_size-1][0] = start;
                intervals[ans_size-1][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                ans_size++;
            }
            else{
                end = Math.max(end,intervals[i][1]);
            }
        }
        intervals[ans_size-1][0] = start;
        intervals[ans_size-1][1] = end;


        int res[][] = new int[ans_size][2];

        for(int i=0;i<ans_size;i++){
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }

        return res;


    }
}