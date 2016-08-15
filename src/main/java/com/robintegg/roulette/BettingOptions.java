package com.robintegg.roulette;

import java.util.ArrayList;
import java.util.Collection;

public class BettingOptions {

	private Collection<Bet> availableBets = new ArrayList<>();

	public Collection<Bet> getAvailableBets() {
		return availableBets;
	}

	public void add(Bet bet) {
		availableBets.add(bet);
	}

}
