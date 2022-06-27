package BasicAlgo.BFS;

import java.util.*;

public class P752_OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        int ans = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNum = queue.poll();
                if (curNum.equals(target)) {
                    return ans;
                }
                for (String nextNum : findNextNum(curNum)) {
                    if (!visited.contains(nextNum) && !dead.contains(nextNum)) {
                        queue.offer(nextNum);
                        visited.add(nextNum);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private List<String> findNextNum(String curNum) {
        List<String> ans = new ArrayList<>();
        char[] arr = curNum.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = (temp == '0' ? '9' : (char)(temp - 1));
            ans.add(new String(arr));
            arr[i] = (temp == '9' ? '0' : (char)(temp + 1));
            ans.add(new String(arr));
            arr[i] = temp;
        }
        return ans;
    }
}
