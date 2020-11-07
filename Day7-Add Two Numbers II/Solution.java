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
    ListNode ans = null;
        
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        
        int s1 = size(l1);
        int s2 = size(l2);
        
        int carry = helper(l1, l2, s1, s2);
        if(carry != 0)
            ans = addFirst( ans, carry );
        
        return ans;
    }
    
    int size(ListNode head)
    {
        int i = 0;
        
        for(ListNode cur = head; cur != null; cur = cur.next, i++);
        
        return i;
    }
    
    ListNode addFirst( ListNode ans, int value )
    {
        if(ans == null)
            ans = new ListNode( value );
        else
        {
            ListNode node = new ListNode( value );
            node.next = ans;
            ans = node;
        }
        return ans;
    }
    
    int helper(ListNode l1, ListNode l2, int s1, int s2)
    {
        int carry = 0, sum;
        if(s1 < s2)
        {
            carry = helper( l1, l2.next, s1, s2-1 );
            sum = l2.val + 0 + carry;
        }
        else if(s1 > s2)
        {
            carry = helper( l1.next, l2, s1-1, s2 );
            sum = l1.val + 0 + carry;
        
        }
        else
        {
            if(s1 == 1)
            {}
            else
                carry = helper( l1.next, l2.next, s1-1, s2-1 );
        
            sum = l1.val + l2.val + carry;
        }
        carry = sum/10;
        sum = sum%10;
        ans = addFirst(ans, sum );
        
        return carry;
    }
        
}