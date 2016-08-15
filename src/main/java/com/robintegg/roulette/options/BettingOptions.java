package com.robintegg.roulette.options;

import java.util.Collection;

public class BettingOptions {

	private Collection<BettingOption> availableBets;

	public BettingOptions(Collection<BettingOption> availableBets) {
		this.availableBets = availableBets;
	}

	public Collection<BettingOption> getAvailableBets() {
		return availableBets;
	}

}
