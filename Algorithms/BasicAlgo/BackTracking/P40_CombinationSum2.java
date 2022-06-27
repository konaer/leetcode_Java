package BasicAlgo.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class P40_CombinationSum2 {
    //2^n
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //pruning
            if (candidates[i] > target) {
                break;
            }
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
