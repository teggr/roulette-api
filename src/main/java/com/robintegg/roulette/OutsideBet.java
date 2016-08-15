package com.robintegg.roulette;

public abstract class OutsideBet extends AbstractBet {

	public OutsideBet(String name, String description, WinningSpace winningSpace) {
		super(name, description, winningSpace);
	}

	@Override
	public Type getType() {
		return Type.OUTSIDE;
	}

}
