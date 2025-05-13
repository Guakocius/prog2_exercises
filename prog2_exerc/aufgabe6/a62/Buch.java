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
        if (getEntleiher() == null) { // entleiher == null
            this.entleiher = p;
            return getEntleiher().leihtAus(this);
        }
        return (this.getEntleiher() == null || this.getEntleiher() == p);
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
            sb.append("ausgeliehen von ").append(getEntleiher().getName());
        else
            sb.append("nicht ausgeliehen");
        System.out.println(sb);
    }
}
