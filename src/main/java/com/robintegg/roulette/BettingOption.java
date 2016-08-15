package com.robintegg.roulette;

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
