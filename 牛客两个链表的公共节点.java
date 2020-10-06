public class 牛客两个链表的公共节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != null) {
            l1 = l1.next;
            len1++;
        }

        while (l2 != null) {
            l2 = l2.next;
            len2++;
        }

        if (len1 >= len2) {
            int k = 0;
            while (k < (len1 - len2)) {
                pHead1 = pHead1.next;
                k++;
            }

            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }else {
            int k = 0;
            while (k < (len2 - len1)) {
                pHead2 = pHead2.next;
                k++;
            }

            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }

        return pHead1;
    }
}
