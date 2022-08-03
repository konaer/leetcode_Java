package PopularTopic.String.Parentheses;

import java.util.*;

public class P22_GenerateParentheses {

    List<String> ans = new ArrayList();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb);
        return ans;
    }

    private void dfs(int n, int left, int right, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
