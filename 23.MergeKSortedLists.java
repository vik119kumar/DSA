class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MergeKLists {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("null\n");
    }

    public static Node sortedMerge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int last = lists.length - 1;

        // repeat until only one list is left
        while (last != 0) {
            int first = 0, second = last;
            while (first < second) {
                lists[first] = sortedMerge(lists[first], lists[second]);
                first++;
                second--;
                // update last if all pairs are merged
                if (first >= second) {
                    last = second;
                }
            }
        }
        return lists[0];
    }

    public static void main(String []args) {
        int k = 3;
        Node[] lists = new Node[k];
        lists[0] = new Node(1);
        lists[0].next = new Node(5);
        lists[0].next.next = new Node(7);
        printList(lists[0]);

        lists[1] = new Node(2);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(6);
        lists[1].next.next.next = new Node(9);
        printList(lists[1]);

        lists[2] = new Node(4);
        lists[2].next = new Node(8);
        lists[2].next.next = new Node(10);
        printList(lists[2]);

        Node head = mergeKLists(lists);
        System.out.print("Merged List: ");
        printList(head);
    }
}

/*
K is number of lists and total number of nodes are N
Approach: Merge Lists in pair till only one list is remaining
Pick first and last list, merge into first list
After each step number of lists will be K/2, K/4, K/8...

Time Complexity: while (last != 0) in mergeKLists will run log(K) times as it is reducing number of lists to half after each step and processing N elements
Total Time Complexity: O(N*logK)
Space Complexity: O(N) N recursive calls in sortedMerge
*/
