package a42;

import java.util.Objects;

/**
 *
 * @author Alexander Engelhardt
 * @author Timothy Drexler
 */
public abstract class Card {
    protected Suit suit;
    protected Rank rank;
    protected static Suit[] suitVal = Suit.values();
    protected static Rank[] rankVal = Rank.values();

    public enum Suit {
        DIAMONDS, CLUBS, HEARTS, SPADES
    }

    public enum Rank {
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }


    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return "(" + suit + "," + rank + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        return this.rank == other.rank && this.suit == other.suit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.suit);
        hash = 53 * hash + Objects.hashCode(this.rank);
        return hash;
    }
}
