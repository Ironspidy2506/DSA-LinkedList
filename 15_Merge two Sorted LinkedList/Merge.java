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

public class Merge {
    static Node firsthead = null;
    static Node secondhead = null;

    public static void insertAtLast(int val, int listNumber) {
        Node newNode = new Node(val);
        Node head = (listNumber == 1) ? firsthead : secondhead;

        if (head == null) {
            if (listNumber == 1)
                firsthead = newNode;
            else
                secondhead = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static Node mergeLinkedList(Node p, Node q) {
        Node dummyNode = new Node(-1);
        Node dummyHead = dummyNode;
        Node temp1 = p, temp2 = q;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                dummyNode.next = new Node(temp1.data);
                temp1 = temp1.next;
                dummyNode = dummyNode.next;
            } else {
                dummyNode.next = new Node(temp2.data);
                temp2 = temp2.next;
                dummyNode = dummyNode.next;
            }
        }

        while (temp1 != null) {
            dummyNode.next = new Node(temp1.data);
            temp1 = temp1.next;
            dummyNode = dummyNode.next;
        }

        while (temp2 != null) {
            dummyNode.next = new Node(temp2.data);
            temp2 = temp2.next;
            dummyNode = dummyNode.next;
        }

        return dummyHead.next;
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
            insertAtLast(n, 1);
        }

        System.out.println("Enter the elements of the second LinkedList (Press -1 to stop):");
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == -1)
                break;
            insertAtLast(n, 2);
        }

        System.out.println("First LinkedList:");
        printLinkedList(firsthead);

        System.out.println("Second LinkedList:");
        printLinkedList(secondhead);

        Node result = mergeLinkedList(firsthead, secondhead);
        System.out.println("Result LinkedList after merging:");
        printLinkedList(result);

        sc.close();
    }
}
