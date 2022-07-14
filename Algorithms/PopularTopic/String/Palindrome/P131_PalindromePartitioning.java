package PopularTopic.String.Palindrome;

import java.util.*;

public class P131_PalindromePartitioning {
    // 分割时间 2^n ， 检查是否回文时间 n,总共为n*2^n;
	// 空间为栈空间 n层
    private List<List<String>> ans = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }
    
    private void dfs(String s, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (!isPalidrome(sub)) {
                continue;
            }
            list.add(sub);
            dfs(s, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean isPalidrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
