package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Hand {
	ArrayList<Card> getHandCards = new ArrayList<Card>();
	ArrayList<Integer> cardSuit = new ArrayList<Integer>();
	ArrayList<Integer> cardRnk = new ArrayList<Integer>();
	Deck deck = new Deck();
	public static HandScore handscore;
	public Hand(){

	}
	public void CreateHand(){
		while (getHandCards.size() < 5){
			Card newCard = deck.Draw();
			this.getHandCards.add(newCard);
			Integer suit = newCard.getiCardSuit();
			this.cardSuit.add(suit);
			Integer rank = newCard.getiCardRnk();
			this.cardRnk.add(rank);
		}
		Collections.sort(cardSuit);
		Collections.sort(cardRnk);
	}
	private int getHandSize(){
		return getHandCards.size();
	}
	public void setHand(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive){
		this.getHandCards.add(cardOne);
		this.getHandCards.add(cardTwo);
		this.getHandCards.add(cardThree);
		this.getHandCards.add(cardFour);
		this.getHandCards.add(cardFive);
		this.cardSuit.add(cardOne.getiCardSuit());
		this.cardSuit.add(cardTwo.getiCardSuit());
		this.cardSuit.add(cardThree.getiCardSuit());
		this.cardSuit.add(cardFour.getiCardSuit());
		this.cardSuit.add(cardFive.getiCardSuit());
		this.cardRnk.add(cardOne.getiCardRnk());
		this.cardRnk.add(cardTwo.getiCardRnk());
		this.cardRnk.add(cardThree.getiCardRnk());
		this.cardRnk.add(cardFour.getiCardRnk());
		this.cardRnk.add(cardFive.getiCardRnk());
		Collections.sort(cardSuit);
		Collections.sort(cardRnk);
	}
	private static boolean isHandFlush (ArrayList<Integer> suits) {
		boolean bIsFlush = false;
		if (suits.get(0) == suits.get(4)){
			bIsFlush = true;
		}
		else{
			bIsFlush = false;
		}
		return bIsFlush;
}
	private static boolean isStraight(ArrayList<Integer> ranks) {
		boolean bIsStraight = false;
		if ((ranks.get(0)+4) == ranks.get(4) && (ranks.get(1)+3) == ranks.get(4) && (ranks.get(2)+2) == ranks.get(4) && (ranks.get(3)+1) == ranks.get(4) ){
			bIsStraight = true;
		}
		else if (ranks.get(0) == 0 && ranks.get(1) == 1 && ranks.get(2) == 2 && ranks.get(3) == 3 &&ranks.get(4) == 12){
		bIsStraight = true;	
		}
		else{
			bIsStraight = false;
		}
		return bIsStraight;
}
	public static boolean isHandRoyalFlush ( Hand hand) {
		boolean isRoyalFlush = false;
		boolean colors = isHandFlush(hand.cardSuit);
		boolean numbs = isStraight(hand.cardRnk);
		if(colors && numbs && hand.cardRnk.get(0) == 8){
			isRoyalFlush = true;
			int handStrength = 110;
			int hiHand = 12;
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			isRoyalFlush =false;
		}
		return isRoyalFlush;
}
	public static boolean isHandStraightFlush ( Hand hand) {
		boolean isStraightFlush = false;
		boolean colors = isHandFlush(hand.cardSuit);
		boolean numbs = isStraight(hand.cardRnk);
		if(colors && numbs && hand.cardRnk.get(0) != 8){
			isStraightFlush = true;
			int handStrength = 100;
			int hiHand = hand.cardRnk.get(4);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			isStraightFlush =false;
		}
		return isStraightFlush;
}
	public static boolean isHandFourOfAKind(Hand hand){
		boolean fourOfAKind = false;
		if (hand.cardRnk.get(0) == hand.cardRnk.get(3)){
			fourOfAKind = true;
			int handStrength = 90;
			int hiHand = hand.cardRnk.get(3);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(1) == hand.cardRnk.get(4)){
			fourOfAKind = true;
			int handStrength = 90;
			int hiHand = hand.cardRnk.get(4);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			fourOfAKind = false;
		}
		return fourOfAKind;	
		}
	public static boolean isHandFullHouse(Hand hand){
		boolean fullHouse = false;
		if (hand.cardRnk.get(0) == hand.cardRnk.get(2) && hand.cardRnk.get(3) == hand.cardRnk.get(4)){
			fullHouse = true;
			int handStrength = 80;
			int hiHand = hand.cardRnk.get(2);
			int loHand = hand.cardRnk.get(3);
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(0) == hand.cardRnk.get(1) && hand.cardRnk.get(2) == hand.cardRnk.get(4)){
			fullHouse = true;
			int handStrength = 80;
			int hiHand = hand.cardRnk.get(3);
			int loHand = hand.cardRnk.get(0);
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			fullHouse = false;
		}
		return fullHouse;	
		}
	public static boolean handFlush ( Hand hand) {
		boolean flush = false;
		boolean colors = isHandFlush(hand.cardSuit);
		if(colors){
			flush = true;
			int handStrength = 70;
			int hiHand = hand.cardRnk.get(4);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			flush =false;
		}
		return flush;
}
	public static boolean handStraight ( Hand hand) {
		boolean isStraight = false;
		boolean numbs = isStraight(hand.cardRnk);
		if(numbs){
			isStraight = true;
			int handStrength = 60;
			int hiHand = hand.cardRnk.get(4);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			isStraight =false;
		}
		return isStraight;
}
	public static boolean isHandThreeOfAKind(Hand hand){
		boolean threeOfAKind = false;
		if (hand.cardRnk.get(0) == hand.cardRnk.get(2)){
			threeOfAKind = true;
			int handStrength = 50;
			int hiHand = hand.cardRnk.get(0);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			kicker.add(hand.cardRnk.get(3));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(1) == hand.cardRnk.get(3)){
			threeOfAKind = true;
			int handStrength = 50;
			int hiHand = hand.cardRnk.get(1);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(2) == hand.cardRnk.get(4)){
			threeOfAKind = true;
			int handStrength = 50;
			int hiHand = hand.cardRnk.get(2);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(1));
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			threeOfAKind = false;
		}
		return threeOfAKind;	
		}
	public static boolean isHandTwoPair(Hand hand){
		boolean twoPair = false;
		if (hand.cardRnk.get(0) == hand.cardRnk.get(1) && hand.cardRnk.get(2) == hand.cardRnk.get(3)){
			twoPair = true;
			int handStrength = 40;
			int hiHand = hand.cardRnk.get(2);
			int loHand = hand.cardRnk.get(0);
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(0) == hand.cardRnk.get(1) && hand.cardRnk.get(3) == hand.cardRnk.get(4)){
			twoPair = true;
			int handStrength = 40;
			int hiHand = hand.cardRnk.get(3);
			int loHand = hand.cardRnk.get(0);
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(2));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(1) == hand.cardRnk.get(2) && hand.cardRnk.get(3) == hand.cardRnk.get(4)){
			twoPair = true;
			int handStrength = 40;
			int hiHand = hand.cardRnk.get(3);
			int loHand = hand.cardRnk.get(1);
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			twoPair = false;
		}
		return twoPair;	
		}	
	public static boolean isHandPair(Hand hand){
		boolean pair = false;
		if (hand.cardRnk.get(0) == hand.cardRnk.get(1)){
			pair = true;
			int handStrength = 30;
			int hiHand = hand.cardRnk.get(0);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			kicker.add(hand.cardRnk.get(3));
			kicker.add(hand.cardRnk.get(2));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(1) == hand.cardRnk.get(2)){
			pair = true;
			int handStrength = 30;
			int hiHand = hand.cardRnk.get(1);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			kicker.add(hand.cardRnk.get(3));
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(2) == hand.cardRnk.get(3)){
			pair = true;
			int handStrength = 30;
			int hiHand = hand.cardRnk.get(2);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(4));
			kicker.add(hand.cardRnk.get(1));
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else if(hand.cardRnk.get(3) == hand.cardRnk.get(4)){
			pair = true;
			int handStrength = 30;
			int hiHand = hand.cardRnk.get(3);
			int loHand = 0;
			ArrayList<Integer> kicker = new ArrayList<Integer>();
			kicker.add(hand.cardRnk.get(2));
			kicker.add(hand.cardRnk.get(1));
			kicker.add(hand.cardRnk.get(0));
			handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		}
		else{
			pair = false;
		}
		return pair;
}
	public static boolean isHandHighCard(Hand hand) {
		int handStrength = 20;
		int hiHand = 0;
		int loHand = 0;
		ArrayList<Integer> kicker = new ArrayList<Integer>();
		kicker.add(hand.cardRnk.get(4));
		kicker.add(hand.cardRnk.get(3));
		kicker.add(hand.cardRnk.get(2));
		kicker.add(hand.cardRnk.get(1));
		kicker.add(hand.cardRnk.get(0));
		handscore = new HandScore(handStrength, hiHand, loHand, kicker);
		return true;
	}
	private HandScore evaluateHand (Hand hand){
		if(isHandRoyalFlush(hand)){
			System.out.println("You have a royal flush!");
			return handscore;
		}
		else if (isHandStraightFlush(hand)){
			System.out.println("You have a straight flush!");
			return handscore;
		}
		else if (isHandFourOfAKind(hand)){
			System.out.println("You have four of a kind!");
			return handscore;
		}
		else if (isHandFullHouse(hand)){
			System.out.println("You have a full House!");
			return handscore;
		}
		else if (handFlush(hand)){
			System.out.println("You have a flush!");
			return handscore;
		}
		else if (handStraight(hand)){
			System.out.println("You have a straight");
			return handscore;
		}
		else if (isHandThreeOfAKind(hand)){
			System.out.println("You have three of a kind");
			return handscore;
		}
		else if (isHandTwoPair(hand)){
			System.out.println("You have two Pair");
			return handscore;
		}
		else if (isHandPair(hand)){
			System.out.println("You have a Pair");
			return handscore;
		}
		else{
			isHandHighCard(hand);
			System.out.println("You have nothing");
			return handscore;
		}
	}
}	