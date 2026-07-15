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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int num = 0;

        ListNode curr = head;

        while(curr != null) {
            num++;
            curr = curr.next;
        }

        if(num==1 && n==1) return null;

        ListNode prev = null;
        curr = head;

        for(int i=0; i<num-n; i++) {
            prev = curr;
            curr = curr.next;
        }

        if(prev==null) head = curr.next;
        else prev.next = curr.next;

        return head;
    }
}
