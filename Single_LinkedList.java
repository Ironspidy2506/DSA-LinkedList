import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Single_LinkedList {
    static Node head = null;

    // Insert at the beginning
    public static void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
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

    // Insert at a specific position
    public static void insertAtPosition(int val, int i) {
        if (i > sizeLL() + 1 || i < 1) {
            System.out.println("Invalid position!!");
            return;
        }

        if (i == 1) {
            insertAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for (int j = 1; j < i - 1; j++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Size of the linked list
    public static int sizeLL() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Print linked list
    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Delete at the beginning
    public static void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        head = head.next;
    }

    // Delete at the last
    public static void deleteAtLast() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at a specific position
    public static void deleteAtPosition(int pos) {
        if (pos > sizeLL() || pos < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    // Search for an element in the linked list
    public static void search(int key) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element not found!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*********************** Linkedlist Implementation ***********************");
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. Insert element in Linkedlist");
            System.out.println("2. Delete element in Linkedlist");
            System.out.println("3. Size of Linkedlist");
            System.out.println("4. Print Linkedlist");
            System.out.println("5. Search element in Linkedlist");
            System.out.println("6. End the Implementation");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("1. Insert at Beginning");
                    System.out.println("2. Insert at Last");
                    System.out.println("3. Insert at any Position");
                    int operationInsert = sc.nextInt();
                    System.out.print("Enter the data to be inserted: ");
                    int data = sc.nextInt();
                    switch (operationInsert) {
                        case 1:
                            insertAtBeginning(data);
                            break;
                        case 2:
                            insertAtLast(data);
                            break;
                        case 3:
                            System.out.println("Enter the position where to be inserted: ");
                            int pos = sc.nextInt();
                            insertAtPosition(data, pos);
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;

                case 2:
                    System.out.println("1. Delete at Beginning");
                    System.out.println("2. Delete at Last");
                    System.out.println("3. Delete at any Position");
                    int operationDelete = sc.nextInt();
                    switch (operationDelete) {
                        case 1:
                            deleteAtBeginning();
                            break;
                        case 2:
                            deleteAtLast();
                            break;
                        case 3:
                            System.out.print("Enter the position to delete: ");
                            int delPos = sc.nextInt();
                            deleteAtPosition(delPos);
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;

                case 3:
                    System.out.println("Size of LinkedList: " + sizeLL());
                    break;

                case 4:
                    printLL();
                    break;

                case 5:
                    System.out.print("Enter the element to search: ");
                    int searchData = sc.nextInt();
                    search(searchData);
                    break;

                case 6:
                    System.out.println("Ending the implementation.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}