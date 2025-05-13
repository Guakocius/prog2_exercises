package a62;

import java.util.LinkedList;
import java.util.List;

/**
 * Person
 */
public class Person {

    private String name;
    private List<Buch> ausgelieheneBuecher;

    public Person(String name) {
        this.name = name;
        ausgelieheneBuecher = new LinkedList<Buch>();
    }
    public String getName() { return this.name; }

    public int getAnzahlAusgeliehenerBuecher() {
        return ausgelieheneBuecher.size();
    }

    public boolean leihtAus(Buch b) {
        if (b.getEntleiher() != null && this != b.getEntleiher()) // Buch schon von jmd anderem entliehen
            return false;
        else   // von dieser Person entliehen => wird zu ausgeliehenen Buechern hinzugefuegt
            if (b.getEntleiher() == this) {
                ausgelieheneBuecher.add(b);
            }
        return b.wirdAusgeliehen(this);
    }

    public boolean gibtZurueck(Buch b) {
        for (Buch buch : ausgelieheneBuecher) {
            if (buch.equals(b)) {
                ausgelieheneBuecher.remove(b);
                return b.wirdZurueckGegeben();
            }
        }
        return false;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" hat ausgeliehen:");

        for (int i = 0; i < ausgelieheneBuecher.size(); i++) {
            if (i != (getAnzahlAusgeliehenerBuecher() - 1))
                sb.append(" ").append(ausgelieheneBuecher.get(i).getName()).append(",");
            else
                sb.append(" ").append(ausgelieheneBuecher.get(i).getName());
        }
        System.out.println(sb);
    }
}
