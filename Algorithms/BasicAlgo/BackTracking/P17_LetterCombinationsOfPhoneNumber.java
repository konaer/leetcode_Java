
package BasicAlgo.BackTracking;

import java.util.*;

public class P17_LetterCombinationsOfPhoneNumber {
    //time 3^n 全排列
    //space n
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        dfs(digits, 0);
        return ans;
    }

    private void dfs(String digits, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            sb.append(c);
            dfs(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}