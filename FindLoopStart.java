class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindLoopStart {
    public static Node findLoopStart(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Phase 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // loop detect
            if (slow == fast) {
                break;
            }
        }

        // No loop
        if (fast == null || fast.next == null) {
            return null;
        }

        // Phase 2: Find loop start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Starting point of loop
    }

    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop
        // 5 -> 3
        head.next.next.next.next.next = head.next.next;

        Node loopStart = findLoopStart(head);
        if (loopStart != null) {
            System.out.println("Loop starts at with node value: " + loopStart.data);
        } else {
            System.out.println("No loop detected");
        }
    }
}