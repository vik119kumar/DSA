public class DeleteNthFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
            if (first == null) {
                return null;
            }
        }

        if (first == null) {
         return dummy.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
/*
Time Complexity: O(N)  where N is the number of elements in the list. 
Space Complexity: O(1)
*/
