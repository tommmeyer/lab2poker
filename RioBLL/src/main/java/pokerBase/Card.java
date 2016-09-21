package pokerBase;
public class Card {
	private int iCardNbr;
	private int iCardRnk;
	private int iCardSuit;
	public Card(int cardRnk, int cardSuit , int cardNbr){
		this.iCardNbr = cardNbr;
		this.iCardRnk = cardRnk;
		this.iCardSuit = cardSuit;
	}
	public int getiCardNbr(){
		return this.iCardNbr;
	}
	public int getiCardRnk(){
		return this.iCardRnk;
	}
	public int getiCardSuit(){
		return this.iCardSuit;
	}
}
