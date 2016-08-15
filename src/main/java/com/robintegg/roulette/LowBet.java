package com.robintegg.roulette;

public class LowBet extends OutsideBet {

	public LowBet() {
		super("Low", "1 to 18 (Low or Manque), A bet that the number will be in the chosen range.",
				new OutsideWinningSpace(Ranges.LOW));
	}

}
