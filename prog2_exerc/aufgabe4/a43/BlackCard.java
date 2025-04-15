package a43;

import java.util.Random;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public class BlackCard extends Card {
	private Random rand = new Random();

    public BlackCard(Suit suit, Rank rank) {
        if (suit == Suit.DIAMONDS || suit == Suit.HEARTS) {
            throw new IllegalArgumentException();
        }
		this.suit = suit;
		this.rank = rank;
    }

    public BlackCard() {
        if (rand.nextInt() % 2 == 0) {
            suit = Suit.CLUBS;
        } else {
            suit = Suit.SPADES;
        }
        rank = rankVal[rand.nextInt(8)];
    }
}
