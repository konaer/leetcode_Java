package DataStructure.Tree.Traversal;

import java.util.*;

public class P301_RemoveInvalidParentheses {
    List<String> ans = new ArrayList<>();
    
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        dfs(s, 0, left, right);
        return ans;
    }
    
    private void dfs(String s, int start, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (left + right > s.length() - i) {
                break;
            }
            if (s.charAt(i) == '(' && left > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right);
            }
            if (s.charAt(i) == ')' && right > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
