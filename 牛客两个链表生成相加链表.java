import java.util.Stack;

public class 牛客两个链表生成相加链表 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dummy = new ListNode(-1);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }

        while (head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }

        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        while (!s1.isEmpty()) {
            int sum = s1.pop() + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        while (!s2.isEmpty()) {
            int sum = s2.pop() + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        return dummy.next;
    }
}
