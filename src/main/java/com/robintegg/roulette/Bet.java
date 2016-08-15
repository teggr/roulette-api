package com.robintegg.roulette;

public interface Bet {

	public enum Type {
		INSIDE, OUTSIDE;
	}

	Type getType();

	String getName();

	String getDescription();

	Payout getPayout();

}
