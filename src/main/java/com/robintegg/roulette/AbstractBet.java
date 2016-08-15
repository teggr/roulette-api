package com.robintegg.roulette;

public abstract class AbstractBet implements Bet {

	private String name;
	private String description;
	private WinningSpace winningSpace;

	public AbstractBet(String name, String description, WinningSpace winningSpace) {
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

}
