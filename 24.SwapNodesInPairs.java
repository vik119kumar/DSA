public class PairNodesSwap {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("null\n");
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void pairSwap() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            int currData = temp.data;
            temp.data = temp.next.data;
            temp.next.data = currData;
            temp = temp.next.next;
        }
    }

    public static void main(String []args) {
        int k = 3;
        PairNodesSwap obj = new PairNodesSwap();
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);

        System.out.print("Original List: ");
        obj.printList();
        obj.pairSwap();
        System.out.print("\nPair Swap List: ");
        obj.printList();
    }
}

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
