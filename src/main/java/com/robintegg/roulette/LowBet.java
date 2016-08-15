package com.robintegg.roulette;

import java.util.Arrays;

public class LowBet extends OutsideBettingOption {

	public LowBet() {
		super("Low", "1 to 18 (Low or Manque), A bet that the number will be in the chosen range.",
				new OutsideWinningSpace(Ranges.LOW));
	}

	@Override
	public boolean isValid(Bet bet, TableLayout layout) {
		return true;
	}

	@Override
	protected boolean isWin(Marker marker, Bet bet) {

		return Arrays.stream(Ranges.HIGH).anyMatch(i -> i == marker.getPocket().getNumberAsInt());

	}

}
