package com.robintegg.roulette;

public class InvalidBet {

	private String reason;
	private Bet bet;
	private boolean rejected;

	public InvalidBet(String reason, Bet bet) {
		this.reason = reason;
		this.bet = bet;
		this.rejected = reason != null;
	}

	public Bet getBet() {
		return bet;
	}

	public String getReason() {
		return reason;
	}

	public boolean isRejected() {
		return rejected;
	}

}
