package DataStructure.LinkedList;

import java.util.PriorityQueue;
public class P23_MergeKSortedList {
    //use heap
    //nklogn, k是每个链的长度
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }

    //divide and conquer
    public ListNode mergeKLists2(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide (ListNode[] lists, int l, int r) {
        //这个是为了计算空集的情况
        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = (r - l) / 2 + l;
        ListNode l1 = divide(lists, l, mid);
        ListNode l2 = divide(lists, mid + 1, r);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}
