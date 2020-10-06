public class 对链表进行插入排序 {
     public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
         // 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
        // 给出的链表为1 -> 1 -> 2, 返回1 -> 2
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
