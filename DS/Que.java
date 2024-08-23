package DS;

public class Que<T> {
    Node head;

    class Node {
        Node next;
        T val;

        Node(T x) {
            val = x;
        }
    }

    public void enque(T x) {
        Node nxt = head;
        Node n1 = new Node(x);
        if (head == null) {
            head = n1;
        } else {
            while (nxt.next != null) {
                nxt = nxt.next;
            }
            nxt.next = n1;
        }
    }

    public T deque() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp.val;
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.print("que is empty");
        }
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T peek() {
        return head.val;
    }
}
