package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	 ArrayList<Card> getDeckCards = new ArrayList<Card>();

	public Deck(){
		int cardRnk;
		int cardSuit;
		int cardNbr = 1;
		for (cardSuit = 0; cardSuit < 4; cardSuit++){
			for (cardRnk = 0; cardRnk < 13; cardRnk++){
				Card nextCard = new Card(cardRnk,cardSuit, cardNbr);
				getDeckCards.add(nextCard);
				cardNbr++;
			}	
		}
		Collections.shuffle(getDeckCards);
	}
	public Card Draw() {
			return getDeckCards.remove(0);
		}
	public int getDeckSize(){
		return getDeckCards.size();
	}
}