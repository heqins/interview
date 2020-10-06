public class 牛客删除有序链表中重复的元素 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head==null||head.next==null)return head;
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==cur.val){
                cur.next=cur.next.next;
            }
            else cur=cur.next;
        }
        return head;
    }
}
