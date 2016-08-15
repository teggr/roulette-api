package com.robintegg.roulette;

public class SplitBet extends InsideBet {

	public SplitBet() {
		super("Split", "Bet on two vertically/horizontally adjacent numbers (e.g. 14-17 or 8-9)",
				"On the edge shared by the numbers", new AdjoiningWinningSpace());
	}

}
