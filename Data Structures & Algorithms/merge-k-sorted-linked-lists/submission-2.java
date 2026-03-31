class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return null;

        return merge(lists, 0, lists.length - 1);
    }

     ListNode merge(ListNode[] lists, int low, int high){

        if(low == high)
            return lists[low];

        int mid = (low + high) / 2;

        ListNode left = merge(lists, low, mid);
        ListNode right = merge(lists, mid + 1, high);

        return mergeTwo(left, right);
    }

     ListNode mergeTwo(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if(l1 != null) temp.next = l1;
        if(l2 != null) temp.next = l2;

        return dummy.next;
    }
}