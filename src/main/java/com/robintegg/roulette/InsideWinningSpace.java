package com.robintegg.roulette;

public class InsideWinningSpace implements WinningSpace {

	private int[] numbers;
	private int squares;

	public InsideWinningSpace(int squares, int... numbers) {
		this.squares = squares;
		this.numbers = numbers;
	}

	@Override
	public Payout getPayout() {
		return new Payout(squares);
	}

}
