package a41;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size = 0;

    private static class Node {
        private Node prev;
        private Node next;
        private Word word;

        public Node(Word w, Node n, Node p) {
            this.word = w;
            this.prev = p;
            this.next = n;
        }
    }
    private Node begin, end;

    public LinkedListFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        begin = new Node(null, null, null);
        end = new Node(null, null, begin);
        begin.next = end;
        size = 0;
    }

    @Override
    public void add(T w, int f) {
        Word wo = new Word(w, f);

        if (size == 0) {
            Node r = new Node(wo, end, begin);
            begin.next = r;
            end.prev = r;
            size++;
        } else {
            for (Node e = end.prev; e.word != null; e = e.prev) {
                if (e.word.getWord().equals(w)) {
                    e.word.addFrequency(f);
                    moveToLeft(e);
                    return;
                }
            }
            Node r = new Node(wo, end, end.prev);

            end.prev.next = r;
            end.prev = r;
            size++;
            moveToLeft(r);
        }
    }

    @Override
    public Word get(int pos) {
        if (pos + 1 > size) return null;
        Node n = begin.next;
        for (int i = 0; i < size; i++) {
            if (i == pos) {
                return n.word;
            } else {
                n = n.next;
            }
        }
        if (pos >= size) return null;
        int counter = size() - 1;
        for (Node e = end.prev; !e.equals(begin); e = e.prev) {
            if (counter == pos) return e.word;
            counter--;
        }
        return null;
    }
    @Override
    public int get(T w) {
        Node n = begin.next;

        for (int i = 0; i < size(); i++) {
            if (n.word.getWord().equals(w)) {
                return n.word.getFrequency();
            } else {
                n = n.next;
            }
        }
        return 0;
    }

    public void moveToLeft(Node n) {
        Word data = n.word;
        while (n.prev.word != null && n.prev.word.getFrequency() < data.getFrequency()) {
            n.word = n.prev.word;
            n = n.prev;
        }
        n.word = data;
    }
}
