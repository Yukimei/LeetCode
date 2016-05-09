package Google;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            minHeap.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            dummy.next = cur;
            minHeap.offer(cur.next);
            dummy = dummy.next;
        }
        return head.next;
    }
}