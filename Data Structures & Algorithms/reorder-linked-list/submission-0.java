/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
               [---------]
1    2.   3    4
          [---------]

 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) 
            return;

        ListNode head2 = split(head);
        ListNode nextNode = reverse(head2);
        merge(head, nextNode);
    }

    private void merge(ListNode a, ListNode b) {
        ListNode n = a;
        a = a.next;

        while(a != null || b != null) {
            if(b!=null) {
                n.next = b;
                n = b;
                b = b.next;
            }
            if(a!=null) {
                n.next = a;
                n = a;
                a = a.next;
            }
        }
    }

    private ListNode split(ListNode n) {
        ListNode s = n, f = n.next;

        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode tmp = s.next;
        s.next = null;

        return tmp;
    }

    private ListNode reverse(ListNode n) {
        ListNode prev = null, curr = n;

        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
