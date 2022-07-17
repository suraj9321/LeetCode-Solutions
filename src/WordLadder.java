import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordLadder {
    public int ladderLength(String bw , String ew, List<String> wl) {
        Map<String,Integer> mp = new HashMap<>();
        for(int i=0;i<wl.size();i++){
            mp.put(wl.get(i),i);
        }

        LinkedList<Integer> adj[] = new LinkedList[wl.size()];
        return 0;
    }
}
