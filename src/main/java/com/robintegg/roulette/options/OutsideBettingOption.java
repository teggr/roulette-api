package com.robintegg.roulette.options;

public abstract class OutsideBettingOption extends AbstractBettingOption {

	public OutsideBettingOption(String name, String description, WinningSpace winningSpace) {
		super(name, description, winningSpace);
	}

	@Override
	public Type getType() {
		return Type.OUTSIDE;
	}

}
