public class PairNodesSwap {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.val = 0;
        ListNode prevNode = dummyNode;
        ListNode currNode = head;     
        while (currNode != null && currNode.next != null) {            
            prevNode.next = currNode.next;
            currNode.next = prevNode.next.next;
            prevNode.next.next = currNode;
            prevNode = currNode;
            currNode = currNode.next;
        }
        return dummyNode.next;
    }
}
/*
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Input: head = []
Output: []

Input: head = [1]
Output: [1]

Time Complexity: O(N)
Space Complexity: O(1)
*/
