package com.robintegg.roulette;

public class HighBet extends OutsideBet {

	public HighBet() {
		super("High", "19 to 36 (High or Passe), A bet that the number will be in the chosen range.",
				new OutsideWinningSpace(Ranges.HIGH));
	}

}
