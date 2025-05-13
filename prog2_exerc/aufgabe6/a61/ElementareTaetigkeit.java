package a61;

import java.util.List;

/**
 * ElementareTaetigkeit
 */
public class ElementareTaetigkeit implements Taetigkeit {

    private double time;
    private String beschr;

    public ElementareTaetigkeit(String beschr, double time) {
        this.beschr = beschr;
        this.time = time;
    }

    @Override
    public double getTime() { return this.time; }

    @Override
    public void add(Taetigkeit tk) {
        throw new UnsupportedOperationException("Not supported..");
    }

    @Override
    public void remove(Taetigkeit tk) {
        throw new UnsupportedOperationException("Not supported..");
    }

    @Override
    public int getAnzahl() {
        return 1;
    }

    @Override
    public String toString() {
        return (this.beschr + ", " + this.time);
    }
}
