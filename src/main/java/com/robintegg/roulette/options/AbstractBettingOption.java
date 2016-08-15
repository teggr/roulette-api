package com.robintegg.roulette.options;

import com.robintegg.roulette.Bet;
import com.robintegg.roulette.Marker;

public abstract class AbstractBettingOption implements BettingOption {

	private String name;
	private String description;
	private WinningSpace winningSpace;

	public AbstractBettingOption(String name, String description, WinningSpace winningSpace) {
		this.name = name;
		this.description = description;
		this.winningSpace = winningSpace;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Payout getPayout() {
		return winningSpace.getPayout();
	}

	@Override
	public double calculateWin(Marker marker, Bet bet) {
		if (isWin(marker, bet)) {
			return bet.getStake() + (bet.getStake() * getPayout().getPayout());
		} else {
			return 0.0;
		}
	}

	protected abstract boolean isWin(Marker marker, Bet bet);

}
