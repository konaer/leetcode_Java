package BasicAlgo.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class P77_Combinations {
    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return ans;
    }    

    private void dfs(int n, int k, int index) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            //注意下面的循环不是每次都结束，所以return不能丢
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
