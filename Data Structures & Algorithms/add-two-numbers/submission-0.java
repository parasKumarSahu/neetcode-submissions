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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode prev = null;
        int carry = 0;

        while(l1!=null || l2!=null) {
            int val1 = 0, val2 = 0;
            if(l1!=null) val1 = l1.val;
            if(l2!=null) val2 = l2.val;

            ListNode curr = new ListNode((val1+val2+carry)%10);
            if(l3==null) l3 = curr;
            if(prev!=null) prev.next = curr;
            prev = curr;

            if((val1+val2+carry)>9) carry = 1;
            else carry = 0;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }

        if(carry == 1) {
            prev.next = new ListNode(1);
        }

        return l3;
    }
}
