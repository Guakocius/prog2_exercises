package aufgabe8;

/**
 *
 * @author Oliver Haase
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


    public LinkedList mergeSort() {
        // hier fehlt Ihr Code
        return this;
    }

}
