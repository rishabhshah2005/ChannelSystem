package DS;

public class LinkedListPrac<T> {
    public class Node {
        public T val;
        public Node next;

        public Node(T val) {
            this.val = val;
        }
    }

    public Node head = null;
    public Node current = head;

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.print("list is empty");
        }
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addLast(T x) {
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

    public void next() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }

    public void prev() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        if (current == head) {
            while (current.next != null) {
                current = current.next;
            }
        } else {
            Node temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            current = temp;
        }
    }

}
