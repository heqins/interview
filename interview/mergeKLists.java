package interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    // 时间复杂度:O(Nlog(K))
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                public int compare(ListNode l1, ListNode l2) {
                    return ((Integer) l1.val).compareTo(l2.val);
                }
            });

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.add(lists[i]);
                }
            }

            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            while (!queue.isEmpty()) {
                ListNode temp = queue.poll();
                cur.next = temp;
                temp = temp.next;
                if (temp != null) queue.add(temp);
                cur = cur.next;
            }

            return dummy.next;
        }
}
