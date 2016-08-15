package com.robintegg.roulette;

public class RedBet extends OutsideBet {

	public RedBet() {
		super("Red", "Rouge, A bet that the number will be the chosen color.", new OutsideWinningSpace(Ranges.RED));
	}

}
