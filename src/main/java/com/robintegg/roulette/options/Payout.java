package com.robintegg.roulette.options;

public class Payout {

	private double squares;

	public Payout(double squares) {
		this.squares = squares;
	}

	public int getPayout() {
		return new Double(Math.floor((1 / squares) * (36 - squares))).intValue();
	}

	public String getPayoutAsString() {
		return getPayout() + " to 1";
	}

}
