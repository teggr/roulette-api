package com.robintegg.roulette;

import com.robintegg.roulette.Pocket.Colour;

public class RedBet extends OutsideBettingOption {

	public RedBet() {
		super("Red", "Rouge, A bet that the number will be the chosen color.", new OutsideWinningSpace(Ranges.RED));
	}

	@Override
	public boolean isValid(Bet bet, TableLayout layout) {
		return true;
	}

	@Override
	protected boolean isWin(Marker marker, Bet bet) {
		return marker.getPocket().getColour() == Colour.Red;
	}

}
