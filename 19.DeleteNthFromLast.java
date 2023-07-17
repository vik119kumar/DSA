public class DeleteNthFromLast {
    class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("X");
    }

    public void deleteNthNodeFromEnd(int n) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        if (first == null) {
            return;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
    }

    public static void main(String args[]) {
        DeleteNthFromLast obj = new DeleteNthFromLast();
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);

        System.out.println("List:");
        obj.show();

        obj.deleteNthNodeFromEnd(2);

        System.out.println("Deleted List:");
        obj.show();
    }
}
/*
Time Complexity: O(N)  where N is the number of elements in the list. 
Space Complexity: O(1)
*/
