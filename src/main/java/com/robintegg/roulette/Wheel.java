package com.robintegg.roulette;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Wheel {

	private List<Pocket> pockets;

	public Wheel(List<Pocket> pockets) {
		this.pockets = pockets;
	}

	public Pocket spin() {
		int pocket = getRandomPocket();
		return pockets.get(pocket);
	}

	private int getRandomPocket() {
		return ThreadLocalRandom.current().nextInt(pockets.size() + 1);
	}

}
