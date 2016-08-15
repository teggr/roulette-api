package com.robintegg.roulette;

public abstract class InsideBet extends AbstractBet {

	private String chipPlacement;

	public InsideBet(String name, String description, String chipPlacement, WinningSpace winningSpace) {
		super(name, description, winningSpace);
		this.chipPlacement = chipPlacement;
	}

	public String getChipPlacement() {
		return chipPlacement;
	}

	@Override
	public Type getType() {
		return Type.INSIDE;
	}

}
