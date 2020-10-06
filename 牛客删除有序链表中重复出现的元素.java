public class 牛客删除有序链表中重复出现的元素 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if (cur != pre.next) {
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
        }
        // 不能return head，有可能链头是重复元素
        return dummy.next;
    }
}
