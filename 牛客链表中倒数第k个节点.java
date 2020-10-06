public class 牛客链表中倒数第k个节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) return null;

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i < k; i++) {
            if (fast.next == null) return null;
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
