package com.robintegg.roulette;

public class BettingResult {

	private Marker marker;
	private Winnings winnings;
	private Croupier croupier;

	public BettingResult(Croupier croupier, Marker marker, Winnings winnings) {
		this.croupier = croupier;
		this.marker = marker;
		this.winnings = winnings;
	}

	public Croupier getCroupier() {
		return croupier;
	}

	public Marker getMarker() {
		return marker;
	}

	public Winnings getWinnings() {
		return winnings;
	}

}
