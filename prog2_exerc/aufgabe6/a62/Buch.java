package a62;

/**
 * Buch
 */
public class Buch {

    private String name;
    private Person entleiher;

    public Buch(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    public Person getEntleiher() {
        return this.entleiher;
    }

    public boolean wirdAusgeliehen(Person p) {
        if (getEntleiher() != p && getEntleiher() != null) // buch von jmd anderem entliehen
            return false;
        else if (getEntleiher() == p) // entleiher ist die Person p
            return true;
        else // entleiher == null
            this.entleiher = p;
            return p.leihtAus(this);
    }

    public boolean wirdZurueckGegeben() {
        if (getEntleiher() == null) // kein entleiher
            return false;
        Person p = getEntleiher();
        this.entleiher = null;
        return !(p.gibtZurueck(this)); //wenn this buch nicht mehr enthalten => return true statt false
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(": ");
        if (getEntleiher() != null)
            sb.append("ausgeliehen von ").append(getEntleiher());
        else
            sb.append("nicht ausgeliehen");
        System.out.println(sb);
    }
}
