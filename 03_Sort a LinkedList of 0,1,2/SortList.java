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

public class SortList {
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

    public static Node sortList(Node head) {
        Node zeros = new Node(-1);
        Node zerosHead = zeros;
        Node ones = new Node(-1);
        Node onesHead = ones;
        Node twos = new Node(-1);
        Node twosHead = twos;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeros.next = new Node(temp.data);
                zeros = zeros.next;
            } else if (temp.data == 1) {
                ones.next = new Node(temp.data);
                ones = ones.next;
            } else {
                twos.next = new Node(temp.data);
                twos = twos.next;
            }
            temp = temp.next;
        }

        zeros.next = onesHead.next;
        ones.next = twosHead.next;

        return zerosHead.next;
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

        Node result = sortList(head);
        System.out.println("Result LinkedList after addition:");
        printLinkedList(result);

        sc.close();
    }
}
