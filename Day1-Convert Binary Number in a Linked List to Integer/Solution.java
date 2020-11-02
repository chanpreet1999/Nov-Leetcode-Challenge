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
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode cur = head;
        while(cur != null)
        {
            ans = (ans << 1) | cur.val;
            cur = cur.next;
            
        }
        return ans;
        
    }
}