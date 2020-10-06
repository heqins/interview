public class 牛客链表奇偶重排 {
    public ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode dummy1 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode cur2 = dummy2;

        int count = 0;
        while (head != null) {
            if (count % 2 == 0) {
                cur1.next = head;
                cur1 = cur1.next;
            }else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            count++;
            head = head.next;
        }

        cur1.next = dummy2.next;
        cur2.next = null;

        return dummy1.next;
    }
}
