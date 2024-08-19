package DS;

import java.util.Scanner;

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

    public boolean contains(T x) {
        if (x.getClass().getSimpleName().equals("Integer")) {
            int a = (int) x;
            Node temp = head;
            if (head == null) {
                return false;
            }
            while (temp != null) {
                if (a == (int) temp.val) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        } else {
            return false;
        }
    }

    public void addLast(T x) {
        Node nxt = head;
        Node n1 = new Node(x);
        if (head == null) {
            head = n1;
            current = head;
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

    private void displayPlayQue() {
        Node temp = head;
        Node start = head;
        int cnt = 0;
        while (temp != null) {
            if (cnt % 10 == 0) {
                start = temp;
            }
            if (temp == current) {
                break;
            }
            cnt++;
            temp = temp.next;
        }
        cnt = 0;
        while (cnt != 10 && start != null) {

            if (start == current) {
                System.out.println(((PlayQue) start.val).channel_name);
            } else {
                System.out.println(Misc.ANSI_GRAY + ((PlayQue) start.val).channel_name +
                        Misc.ANSI_RESET);
            }
            start = start.next;
            cnt++;
        }

        System.out.println();
        String[] headings = { "StartTime", "EndTime" };
        String[] headings2 = { "Current" };
        System.out.println(
                Misc.padAllRight(headings2, 40, Misc.ANSI_YELLOW) + Misc.padAllRight(headings, 20, Misc.ANSI_YELLOW));
        String[] play = { Misc.printTime(((PlayQue) current.val).start),
                Misc.printTime(((PlayQue) current.val).end) };
        String[] play2 = { ((PlayQue) current.val).prog_name };
        System.out.println(Misc.padAllRight(play2, 40) + Misc.padAllRight(play, 20));

    }

    public void playTV(Scanner inp) {
        if (head == null) {
            Misc.cls();
            System.out.println(Misc.ANSI_RED + "QUEUE IS EMPTY" + Misc.ANSI_RESET);
            return;
        }
        if (!head.val.getClass().getSimpleName().equals("PlayQue")) {
            return;
        } else {
            int index = 0;
            while (index != 3) {
                Misc.cls();
                displayPlayQue();
                System.out.println();
                System.out.println("1) Next");
                System.out.println("2) Prev");
                System.out.println("3) Exit");
                index = Misc.checkInt(inp, "Enter index: ");
                switch (index) {
                    case 1:
                        next();
                        break;
                    case 2:
                        prev();
                        break;
                    case 3:
                        Misc.cls();
                        break;

                    default:
                        System.out.println("Enter correct index!!");
                        break;
                }
            }
        }
    }
}
