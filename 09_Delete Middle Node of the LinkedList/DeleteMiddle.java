import java.util.*;

class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class DeleteMiddle {
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

    public static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        int size = sizeLL(head);
        int middle = (size - 1) / 2;
        if (middle == 0) {
            return head.next;
        }

        Node curr = head;
        Node prev = null;

        for (int i = 0; i < middle; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

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

        System.out.println("Enter the elements of the LinkedList (Press -1 to stop):");
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == -1)
                break;
            insertAtLast(n);
        }

        System.out.println("Original LinkedList:");
        printLinkedList(head);

        Node result = deleteMiddleNode(head);
        System.out.println("LinkedList After Deleting the Middle Element:");
        printLinkedList(result);

        sc.close();
    }
}
