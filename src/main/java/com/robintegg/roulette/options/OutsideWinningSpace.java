package com.robintegg.roulette.options;

public class OutsideWinningSpace implements WinningSpace {

	private int[] numbers;

	public OutsideWinningSpace(int... numbers) {
		this.numbers = numbers;
	}

	@Override
	public Payout getPayout() {
		return new Payout(numbers.length);
	}

}
