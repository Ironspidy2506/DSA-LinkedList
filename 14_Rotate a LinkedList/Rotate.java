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

public class Rotate {
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

    public static Node rotateLinkedList(Node head, int rot) {
        Node dummyNode = new Node(-1);
        Node dummyHead = dummyNode;

        Node currNode = head;
        currNode.prev = null;
        Node prevNode = null;
        for (int i = 1; i <= rot; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        prevNode.next = null;
        while (currNode != null) {
            dummyNode.next = new Node(currNode.data);
            dummyNode = dummyNode.next;
            currNode = currNode.next;
        }

        while (head != null) {
            dummyNode.next = new Node(head.data);
            dummyNode = dummyNode.next;
            head = head.next;
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

        System.out.print("Enter the times the LinkedList must be rotated: ");
        int k = sc.nextInt();

        Node result = rotateLinkedList(head, k);
        System.out.println("Result LinkedList after Removing Duplicates:");
        printLinkedList(result);

        sc.close();
    }
}