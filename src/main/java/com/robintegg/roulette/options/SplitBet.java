package com.robintegg.roulette.options;

import com.robintegg.roulette.Bet;
import com.robintegg.roulette.Marker;
import com.robintegg.roulette.TableLayout;

public class SplitBet extends InsideBettingOption {

	public SplitBet() {
		super("Split", "Bet on two vertically/horizontally adjacent numbers (e.g. 14-17 or 8-9)",
				"On the edge shared by the numbers", new AdjoiningWinningSpace());
	}

	@Override
	public boolean isValid(Bet bet, TableLayout layout) {
		return true;
	}

	@Override
	protected boolean isWin(Marker marker, Bet bet) {
		// TODO Auto-generated method stub
		return false;
	}

}
