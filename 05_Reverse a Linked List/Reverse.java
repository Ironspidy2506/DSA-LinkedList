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

public class Reverse {
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

    public static Node reverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of LinkedList (Press -1 to stop)");

        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            insertAtLast(n);
        }

        System.out.println("Original LinkedList:");
        printLinkedList(head);

        Node temp = reverseLinkedList(head);
        System.out.println("Result List after Reversing:");
        printLinkedList(temp);

        sc.close();
    }
}
