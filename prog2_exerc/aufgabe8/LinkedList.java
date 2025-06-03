package aufgabe8;

/**
 *
 * @author Oliver Haase
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */


public class LinkedList {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public LinkedList add(int value) {
        head = new Node(value, head);
        size++;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        Node p = head;
        boolean firstElement = true;
        while (p != null) {
            if (!firstElement)
                builder.append(", ");
            else
                firstElement = false;
            builder.append(p.value);
            p = p.next;
        }
        builder.append("}, size = " + size);
        return builder.toString();
    }

    private Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public LinkedList mergeSort() {
        int len = this.size;
        if (len <= 1) {
            return this;
        }
        Node sortedHead = mergeSort(head);
        LinkedList sortedList = new LinkedList();
        Node current = sortedHead;
        while (current != null) {
            sortedList.add(current.value);
            current = current.next;
        }
        this.head = sortedList.head;
        this.size = sortedList.size;
        this.head = reverseList(this.head);
        
        return this;
    }

    private Node mergeSort(Node n) {
        if (n == null || n.next == null) {
            return n;
        }
        Node m = getMiddle(n);
        Node mNext = m.next;
        m.next = null;

        Node l = mergeSort(n);
        Node r = mergeSort(mNext);

        return merge(l, r);
    }

    private Node merge(Node l, Node r) {
        if (l == null) return r;
        if (r == null) return l;

        if (l.value <= r.value) {
            l.next = merge(l.next, r);
            return l;
        } else {
            r.next = merge(l, r.next);
            return r;
        }
    }
    private Node getMiddle(Node n) {
        if (n == null) return n;
        Node slow = n;
        Node fast = n.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
