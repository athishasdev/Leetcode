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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode rev = reverse(head);

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while(rev != null){
            while(!stack.isEmpty() && stack.peek() <= rev.val) stack.pop();

            if(stack.isEmpty()) list.add(0);
            else list.add(stack.peek());
            
            stack.push(rev.val);
            rev = rev.next;
        }

        int[] arr = new int[list.size()];
        int index = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            arr[index++] = (int)list.get(i);
        }

        return arr;
    }
}