package com.robintegg.roulette;

public class Winning {

	private double calculatedWin;
	private Bet bet;

	public Winning(Marker marker, Bet bet, BettingOption bettingOption) {
		this.bet = bet;
		this.calculatedWin = bettingOption.calculateWin(marker, bet);
	}

	public double getCalculatedWin() {
		return calculatedWin;
	}

	public Bet getBet() {
		return bet;
	}

}
