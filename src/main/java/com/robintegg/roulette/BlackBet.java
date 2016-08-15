package com.robintegg.roulette;

public class BlackBet extends OutsideBet {

	public BlackBet() {
		super("Black", "Noir, A bet that the number will be the chosen color.", new OutsideWinningSpace(Ranges.BLACK));
	}

}
