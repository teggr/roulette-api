package com.robintegg.roulette;

public abstract class InsideBettingOption extends AbstractBettingOption {

	private String chipPlacement;

	public InsideBettingOption(String name, String description, String chipPlacement, WinningSpace winningSpace) {
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
