package aufgabe2;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
public class LinkedListFrequencyTable extends AbstractFrequencyTable {
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
    private Node begin, end, b1, e1;

    public LinkedListFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        b1 = new Node(null, e1, begin);
        e1 = new Node(null, end, b1);
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        Word wo = new Word(w, f);

        if (size == 0) {
            Node r = new Node(wo, e1, b1);
            b1.next = r;
            e1.prev = r;
            size++;
        } else {
            Node e = e1.prev;
            boolean freqAdd = false;
            for (int i = size - 1; i >= 0; i--) {
                if (e.word.getWord().equals(w)) {
                    e.word.addFrequency(f);
                    sort(e);
                    freqAdd = true;
                    break;
                }
                e = e.prev;
            }
            if (freqAdd == false) {
                Node r = new Node(wo, e1, e1.prev);

                e1.prev.next = r;
                e1.prev = r;
                size++;
                sort(r);
            }
        }
    }

    @Override
    public Word get(int pos) {
        if (pos + 1 > size) return null;
        Node n = b1.next;
        for (int i = 0; i < size; i++) {
            if (i == pos) {
                return n.word;
            } else {
                n = n.next;
            }
        }
        if (pos >= size) return null;
        int counter = size() - 1;
        for (Node e = e1.prev; !e.equals(b1); e = e.prev) {
            if (counter == pos) return e.word;
            counter--;
        }
        return null;
    }
    @Override
    public int get(String w) {
        Node n = b1.next;

        for (int i = 0; i < size(); i++) {
            if (n.word.getWord().equals(w)) {
                return n.word.getFrequency();
            } else {
                n = n.next;
            }
        }
        return 0;
    }

    public void sort(Node n) {
        int freq = n.word.getFrequency();
        Word t = n.word;
        Node p = n.prev;
        while (!p.equals(b1) && p.word.getFrequency() < freq) {
            p.next.word = p.word;
            p = p.prev;

        }
        if (p.equals(b1)) {
            b1.next.word = t;
        } else {
            p.next.word = t;
        }

    }
}
