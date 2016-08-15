package com.robintegg.roulette.options;

import com.robintegg.roulette.Bet;
import com.robintegg.roulette.Marker;
import com.robintegg.roulette.TableLayout;

public interface BettingOption {

	public enum Type {
		INSIDE, OUTSIDE;
	}

	Type getType();

	String getName();

	String getDescription();

	Payout getPayout();

	boolean isValid(Bet bet, TableLayout layout);

	double calculateWin(Marker marker, Bet bet);

}
