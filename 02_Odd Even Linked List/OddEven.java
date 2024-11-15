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

public class OddEven {
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

    public static Node segregateOddEven(Node head) {
        if (head == null) {
            return null;
        }

        Node dummyOdd = new Node(-1);
        Node dummyOddHead = dummyOdd;
        Node dummyEven = new Node(-1);
        Node dummyEvenHead = dummyEven;

        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt % 2 != 0) {
                dummyOdd.next = new Node(temp.data);
                dummyOdd = dummyOdd.next;
            } else {
                dummyEven.next = new Node(temp.data);
                dummyEven = dummyEven.next;
            }
            temp = temp.next;
        }

        dummyEvenHead = dummyEvenHead.next;
        dummyOdd.next = dummyEvenHead;

        return dummyOddHead.next;
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

        System.out.println("Original LinkedList:");
        printLinkedList(head);

        Node result = segregateOddEven(head);
        System.out.println("Result LinkedList after addition:");
        printLinkedList(result);

        sc.close();
    }
}
