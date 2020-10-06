public class 分割链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (head != null && head.next != null) {
            ListNode next = head.next;
            if (head.val <= x) {
                head.next = null;
                l1.next = head;
                l1 = l1.next;
            }else {
                head.next = null;
                l2.next = head;
                l2 = l2.next;
            }

            head = next;
        }

        l1.next = cur2.next;

        return cur1.next;
    }
}
