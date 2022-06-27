package BasicAlgo.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39_CombinationSum {
    //时间复杂度，最差情况，每个都是解，这时候有2^n个解，放入list需要n，一共需要n*2^n
	//实际远比这个小，因为有pruning，实际是每个可行解的长度之和
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (target < candidates[i]) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        } 
    }
}
