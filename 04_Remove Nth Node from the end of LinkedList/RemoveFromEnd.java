import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveFromEnd {
    static Node head = null;

    public static void insertAtLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static int sizeLL(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static Node removeNthNode(Node head, int n) {
        int size = sizeLL(head);
        if(n > size) {
            System.out.println("This can't be done!!");
            return null;
        }

        Node temp = head;
        for(int i = 1; i < size - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements of the first LinkedList (Press -1 to stop):");
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == -1)
                break;
            insertAtLast(n);
        }

        System.out.print("Enter the Nth position to remove from the end: ");
        int n = sc.nextInt();

        System.out.println("Original LinkedList:");
        printLinkedList(head);

        Node result = removeNthNode(head, n);
        System.out.println("Result LinkedList after addition:");
        printLinkedList(result);

        sc.close();
    }
}
