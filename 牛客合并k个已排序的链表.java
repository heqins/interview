import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 牛客合并k个已排序的链表 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        // 这里要注意，默认的堆没有对ListNode实现排序的方法
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return (Integer)l1.val - (Integer)l2.val;
            }
        });
        int k = lists.size();
        for (int i = 0; i < k; i++) {
            // 要注意链表的节点有可能为空
            if (lists.get(i) != null) {
                q.offer(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!q.isEmpty()) {
            ListNode cur = q.poll();
            head.next = cur;
            cur = cur.next;
            // 这里同样要进行判断是否为空的操作
            if (cur != null) q.offer(cur);
            head = head.next;
        }

        return dummy.next;
    }
}
