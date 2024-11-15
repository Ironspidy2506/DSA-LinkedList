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

public class Add {
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

    public static Node addTwoNumbers(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        Node p = reverseLinkedList(l1);
        Node q = reverseLinkedList(l2);
        Node dummyNode = new Node(-1);
        Node dummyhead = dummyNode;

        int carry = 0;
        while (p != null || q != null) {
            int p_data = (p != null) ? p.data : 0;
            int q_data = (q != null) ? q.data : 0;

            int sum = carry + p_data + q_data;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            dummyNode.next = new Node(carry);
        }

        return dummyhead.next;
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

        Node result = addTwoNumbers(firsthead, secondhead);
        System.out.println("Result LinkedList after addition:");
        printLinkedList(result);

        sc.close();
    }
}
