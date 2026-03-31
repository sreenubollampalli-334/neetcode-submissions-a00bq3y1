/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
     ListNode first=head;
       ListNode second= reverse(slow.next);
       slow.next=null;
       while(first!=null&&second!=null){
        ListNode temp1=first.next;
        ListNode temp2=second.next;
        first.next=second;
        second.next=temp1;
        first=temp1;
        second=temp2;
     
       }


        
    }
    static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode front=cur.next;
            cur.next=prev;
            prev=cur;
            cur=front;
        }
        return prev;
    }
}
