package com.robintegg.roulette.options;

import java.util.Arrays;

import com.robintegg.roulette.Bet;
import com.robintegg.roulette.Marker;
import com.robintegg.roulette.Ranges;
import com.robintegg.roulette.TableLayout;

public class HighBet extends OutsideBettingOption {

	public HighBet() {
		super("High", "19 to 36 (High or Passe), A bet that the number will be in the chosen range.",
				new OutsideWinningSpace(Ranges.HIGH));
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
