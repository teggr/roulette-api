package com.robintegg.roulette;

import java.util.Arrays;

public class SimpleBet implements Bet {

	private String name;
	private double stake;
	private int[] numbers;

	public void setName(String name) {
		this.name = name;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getStake() {
		return stake;
	}

	@Override
	public int[] getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return "SimpleBet [name=" + name + ", stake=" + stake + ", numbers=" + Arrays.toString(numbers) + "]";
	}

}
