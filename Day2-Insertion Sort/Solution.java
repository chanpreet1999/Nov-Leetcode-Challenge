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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode cur = head.next;
        ListNode prev = head;
        
        while(cur != null)
        {
            ListNode next = cur.next;
            
            ListNode pos = findPosition(head, cur);
            if(cur == pos)
            {
                prev = cur;
            }
            else
            {
                prev.next = cur.next;
                cur.next = null;
                
                if(pos == null)
                {
                    head = insertBegin(head, cur);
                }
                    
                else
                {
                    head=insertAfter( head ,pos, cur);
                }
                    
            
            }
            
            cur = next;
            
        }
        return head;
    }
    
    ListNode findPosition( ListNode head, ListNode node )
    {
        ListNode prev = null, cur = head;
        while( cur != null)
        {
            if(cur == node)
                return cur;
            else if(cur.val > node.val)
                return prev;
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    ListNode insertBegin(ListNode head, ListNode node)
    {
        node.next = head;
        head = node;
        return head;
        
    }
    
    ListNode insertAfter(ListNode head, ListNode pos, ListNode node)
    {
        ListNode next = pos.next;
        pos.next = node;
        node.next = next;
        return head;
    }
}