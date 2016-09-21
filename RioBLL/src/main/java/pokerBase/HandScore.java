package pokerBase;

import java.util.ArrayList;

public class HandScore {


	private int HandStrength;
	private int HiHand;
	private int LoHand = 0;
	private ArrayList<Integer> Kickers = new ArrayList<Integer>();
	
	public HandScore() {}
	
	public HandScore(int handStrength, int hiHand, int loHand, ArrayList<Integer> kickers) {
		super();
		HandStrength = handStrength;
		HiHand = hiHand;
		LoHand = loHand;
		Kickers = kickers;
	}

	public int getHandStrength() {
		return HandStrength;
	}

	public void setHandStrength(int handStrength) {
		HandStrength = handStrength;
	}

	public int getHiHand() {
		return HiHand;
	}

	public void setHiHand(int hiHand) {
		HiHand = hiHand;
	}

	public int getLoHand() {
		return LoHand;
	}

	public void setLoHand(int loHand) {
		LoHand = loHand;
	}

	public ArrayList<Integer> getKickers() {
		return Kickers;
	}

	public void setKickers(ArrayList<Integer> kickers) {
		Kickers = kickers;
	}

}
