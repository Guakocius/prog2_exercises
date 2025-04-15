package a43;

import java.util.Random;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public class RedCard extends Card {
	private Random rand = new Random();
	
	public RedCard(Suit suit, Rank rank) {
		if (suit == Suit.CLUBS || suit == Suit.SPADES)
			throw new IllegalArgumentException();
		this.suit = suit;
		this.rank = rank;
	} 
	
	public RedCard() {
		if (rand.nextInt() % 2 == 0)	
			suit = Suit.DIAMONDS;
		else
			suit = Suit.HEARTS;
		rank = rankVal[rand.nextInt(8)];
	}
}
