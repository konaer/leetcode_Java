package SingleScan;

import java.util.*;

public class P759_EmployeeFreeTime {
    
    class Interval {
        public int start;
        public int end;
    
        public Interval() {}
    
        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
    
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> people : schedule) {
            for (Interval interval : people) {
                pq.offer(interval);
            }
        }

        List<Interval> ans = new ArrayList<>();
        Interval cur = pq.poll();
        while (!pq.isEmpty()) {
            if (cur.end >= pq.peek().start) {
                cur.end = Math.max(cur.end, pq.poll().end);
            } else {
                ans.add(new Interval(cur.end, pq.peek().start));
                cur = pq.poll();
            }
        }
        return ans;
    }
}
