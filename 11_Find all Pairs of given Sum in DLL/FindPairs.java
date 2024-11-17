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

public class FindPairs {
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

    public static List<List<Integer>> findAllPairs(Node head, int k) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == k) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(list.get(i));
                    tempList.add(list.get(j));
                    result.add(tempList);
                }
            }
        }

        return result;
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

        List<List<Integer>> result = findAllPairs(head, k);
        System.out.println("Pairs that exists in LinkedList are:");
        System.out.println(result);

        sc.close();
    }
}