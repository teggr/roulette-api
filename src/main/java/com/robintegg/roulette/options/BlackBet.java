package com.robintegg.roulette.options;

import com.robintegg.roulette.Bet;
import com.robintegg.roulette.Marker;
import com.robintegg.roulette.Ranges;
import com.robintegg.roulette.TableLayout;
import com.robintegg.roulette.Pocket.Colour;

public class BlackBet extends OutsideBettingOption {

	public BlackBet() {
		super("Black", "Noir, A bet that the number will be the chosen color.", new OutsideWinningSpace(Ranges.BLACK));
	}

	@Override
	public boolean isValid(Bet bet, TableLayout layout) {
		return true;
	}

	@Override
	protected boolean isWin(Marker marker, Bet bet) {
		return marker.getPocket().getColour() == Colour.Black;
	}

}
