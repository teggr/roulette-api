package com.robintegg.roulette;

public class StraightOrSingleBet extends InsideBet {

	public StraightOrSingleBet() {
		super("Straight/Single", "Bet on a single number", "Entirely within the square for the chosen number",
				new InsideWinningSpace(1, Ranges.ALL_BUT_ZERO));
	}

}
