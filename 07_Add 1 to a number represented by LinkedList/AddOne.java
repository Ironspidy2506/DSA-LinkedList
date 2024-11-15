import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddOne {
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

    public static Node reverseLinkedList(Node head) {
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

    public static Node addOnetoLL(Node head) {
        Node p = reverseLinkedList(head);
        Node dummyNode = new Node(-1);
        Node dummyHead = dummyNode;

        int carry = 1;
        while (carry == 1) {
            int sum = carry + p.data;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;

            p = p.next;
        }

        while (p != null) {
            Node newNode = new Node(p.data);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            p = p.next;
        }

        return reverseLinkedList(dummyHead.next);
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

        Node result = addOnetoLL(head);
        System.out.println("LinkedList after adding 1 to it:");
        printLinkedList(result);

        sc.close();
    }
}
