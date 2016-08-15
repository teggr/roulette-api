package com.robintegg.roulette;

public class Pocket {

	private static final String DOUBLE_ZERO = "00";

	public enum Colour {
		Red, Black, Green;
	}

	private String number;
	private Colour colour;

	public Pocket(String number) {
		this.number = number;
		if (isAZero()) {
			this.colour = Colour.Green;
		} else if (matchesRange(1, 10) || matchesRange(19, 28)) {
			if (isOdd()) {
				this.colour = Colour.Red;
			} else {
				this.colour = Colour.Black;
			}
		} else if (matchesRange(11, 18) || matchesRange(29, 36)) {
			if (isOdd()) {
				this.colour = Colour.Black;
			} else {
				this.colour = Colour.Red;
			}
		} else {
			throw new IllegalArgumentException("is not a valid pocket");
		}
	}

	public boolean isAZero() {
		return isDoubleZero() || isZero();
	}

	public boolean isOdd() {
		if (isAZero()) {
			return false;
		}
		return getNumberAsInt() % 2 != 0;
	}

	public boolean isEven() {
		if (isAZero()) {
			return false;
		}
		return getNumberAsInt() % 2 == 0;
	}

	public boolean isZero() {
		return getNumberAsInt() == 0;
	}

	public boolean isDoubleZero() {
		return this.number.equals(DOUBLE_ZERO);
	}

	public int getNumberAsInt() {
		return Integer.parseInt(number);
	}

	public boolean matchesRange(int start, int end) {
		return getNumberAsInt() >= start && getNumberAsInt() <= end;
	}

	public Colour getColour() {
		return colour;
	}

	public String getNumber() {
		return number;
	}
}
