import java.util.Stack;

public class 牛客判断一个链表是否为回文结构 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * // write code here
     *         if(head == null || head.next == null)return true;
     *         ListNode slow = head, fast = head;
     *         while(fast.next != null && fast.next.next != null){
     *             slow = slow.next;
     *             fast = fast.next.next;
     *         }
     *         ListNode right = slow.next;
     *         slow.next = null;
     *         ListNode pre = null;
     *         while(right != null){
     *             ListNode nex = right.next;
     *             right.next = pre;
     *             pre = right;
     *             right = nex;
     *         }
     *         right = pre;
     *         while(head != null && right != null){
     *             if(head.val != right.val)return false;
     *             head = head.next;
     *             right = right.next;
     *         }
     *         return true;
     *     }
     * @param head
     * @return
     */
    public boolean isPail (ListNode head) {
        // write code here
        Stack<Integer> s = new Stack<>();

        ListNode cur = head;

        while (cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }

        while (head != null) {
            if (head.val != s.pop()) {
                return false;
            }

            head = head.next;
        }

        return true;
    }
}
