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
        begin = new Node(null, end, null);
        end = new Node(null, null, begin);
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        Word wo = new Word(w, f);

        if (size == 0) {
            Node r = new Node(wo, end, begin);
            begin.next = r;
            end.prev = r;
            size++;
        } else {
            Node e = end.prev;
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
                Node r = new Node(wo, end, end.prev);

                end.prev.next = r;
                end.prev = r;
                size++;
                sort(r);
            }
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
    public int get(String w) {
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

    public void sort(Node n) {
        int freq = n.word.getFrequency();
        Word t = n.word;
        Node p = n.prev;
        while (!p.equals(begin) && p.word.getFrequency() < freq) {
            p.next.word = p.word;
            p = p.prev;

        }
        if (p.equals(begin)) {
            begin.next.word = t;
        } else {
            p.next.word = t;
        }

    }
}
