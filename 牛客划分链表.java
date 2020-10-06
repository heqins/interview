public class 牛客划分链表 {
    public ListNode partition (ListNode head, int x) {
        // write code here
        ListNode preHead1 = new ListNode(0), preHead2 = new ListNode(0);
        ListNode cur1 = preHead1, cur2 = preHead2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = preHead2.next;
        cur2.next = null;
        return preHead1.next;
    }
}
