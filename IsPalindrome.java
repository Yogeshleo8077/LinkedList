class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IsPalindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // first find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Node secondHalf = reverseList(slow.next);

        // compares both halves
        Node firstHalf = head;
        Node temp = secondHalf;

        boolean isPalindrome = true;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                isPalindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return isPalindrome;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        if (isPalindrome(head)) {
            System.out.println("Linked List is Palindrome.");
        } else {
            System.out.println("Linked List is Not Palinedrome.");
        }
    }
}
