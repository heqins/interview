public class 旋转链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        // 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
        ListNode slow = head, fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        ListNode l2 = fast.next;
        fast.next = null;

        ListNode dummy = new ListNode(-1);

        while (l2 != null && l2.next != null) {
            dummy.next = l2;
            l2 = l2.next;
        }

        while (slow != null && slow.next != null) {
            dummy.next = slow;
            slow = slow.next;
        }

        return dummy.next;
    }
}
