package com.robintegg.roulette;

import java.util.Collection;

public class Winnings {

	private Collection<Winning> bets;

	public Winnings(Collection<Winning> bets) {
		this.bets = bets;
	}

	public Collection<Winning> getBets() {
		return bets;
	}

}
