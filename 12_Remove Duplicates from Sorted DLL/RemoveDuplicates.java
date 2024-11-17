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

public class RemoveDuplicates {
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

    public static Node removeDuplicates(Node head) {
        Node curr = head;

        while (curr != null) {
            Node temp = curr.next;
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }

            curr.next = temp;
            if (temp != null) {
                temp.prev = curr;
            }

            curr = curr.next;
        }

        return head;
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

        Node result = removeDuplicates(head);
        System.out.println("Result LinkedList after Removing Duplicates:");
        printLinkedList(result);

        sc.close();
    }
}