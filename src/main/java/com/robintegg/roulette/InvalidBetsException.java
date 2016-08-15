package com.robintegg.roulette;

import java.util.Collection;

@SuppressWarnings("serial")
public class InvalidBetsException extends RuntimeException {

	private Collection<InvalidBet> bets;

	public InvalidBetsException(Collection<InvalidBet> bets) {
		this.bets = bets;
	}

	public Collection<InvalidBet> getBets() {
		return bets;
	}

}
