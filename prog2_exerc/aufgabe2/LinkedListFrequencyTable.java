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
        b1 = new Node(null, end, null);
        e1 = new Node(null, null, b1);
        b1.next = e1;
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        Word wo = new Word(w, f);

        if (size == 0) {
            Node n = new Node(wo, e1, b1);
            b1.next = n;
            e1.prev = n;
            size++;
        } else if (size > 0) {
            int c = 0;
            for (Node n = b1.next; !n.equals(e1); n = n.next) {
                if (c == size) {

                }
                if (n.word.getWord().equals(w)) {
                    n.word.addFrequency(f);
                    sort(n);
                    break;
                }
            }
            Node nn = new Node(wo, e1, e1.prev);
            size++;
            sort(nn);
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
        return null;
    }
    @Override
    public int get(String w) {
        Node n = b1.next;
        
        for (int i = 0; i < size; i++) {

            if (n.word.getWord().equals(w)) {
                return n.word.getFrequency();
            } else n = n.next;
        }
        return 0;
    }

// TODO: Remove NullPointerException (word or freq or (word and freq) is null)
    public void sort(Node n) {
        Word t = n.word;
        Node nt = n.prev;

        while (!nt.equals(b1) && nt.prev.word.getFrequency() < t.getFrequency()) {
            n.word = nt.word;
            nt = nt.prev;
        }
        nt.word = t;
    
        if (nt.prev.equals(b1)) {
            b1 = nt;
        }
            
    
        
    }
    
}
