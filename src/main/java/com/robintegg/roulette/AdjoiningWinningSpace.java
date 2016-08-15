package com.robintegg.roulette;

public class AdjoiningWinningSpace implements WinningSpace {

	@Override
	public Payout getPayout() {
		return new Payout(2);
	}

}
