package com.robintegg.roulette;

public class StraightOrSingleBet extends InsideBettingOption {

	public StraightOrSingleBet() {
		super("Straight/Single", "Bet on a single number", "Entirely within the square for the chosen number",
				new InsideWinningSpace(1, Ranges.ALL_BUT_ZERO));
	}

	@Override
	public boolean isValid(Bet bet, TableLayout layout) {
		return true;
	}

	@Override
	protected boolean isWin(Marker marker, Bet bet) {
		return bet.getNumbers()[0] == marker.getPocket().getNumberAsInt();
	}

}
