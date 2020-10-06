/**
 * 题目描述: 链表的入环节点，如果无环，返回null
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up: Can you solve it without using extra space?
 * 思路：
 * 1）首先判断是否有环,有环时，返回相遇的节点，无环，返回null
 * 2）有环的情况下， 求链表的入环节点
 *   fast再次从头出发，每次走一步，
 *   slow从相遇点出发，每次走一步，
 *   再次相遇即为环入口点。
 * 注：此方法在牛客BAT算法课链表的部分有讲解。
 */
//nowcoder pass
public class 牛客链中环的入口位置 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode meetNode = meetingNode(head);
        if (meetNode == null) {//说明无环
            return null;
        }

        ListNode fast = head;
        ListNode slow = meetNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    //寻找相遇节点，如果无环，返回null
    public ListNode meetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}