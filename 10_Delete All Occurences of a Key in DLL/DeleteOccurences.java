import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DeleteOccurences {
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
        newNode.prev = temp;
    }

    public static Node deleteAllOccurences(Node head, int key) {
        Node dummyNode = new Node(-1);
        Node dummyHead = dummyNode;

        Node temp = head;
        while (temp != null) {
            if (temp.data != key) {
                dummyNode.next = new Node(temp.data);
                dummyNode = dummyNode.next;
            }
            temp = temp.next;
        }

        return dummyHead.next;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
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

        System.out.println("LinkedList:");
        printLinkedList(head);

        System.out.print("Enter the target value: ");
        int k = sc.nextInt();

        Node result = deleteAllOccurences(head, k);
        System.out.println("Pairs that exists in LinkedList are:");
        printLinkedList(result);

        sc.close();
    }
}