package com.robintegg.roulette;

import java.util.Collection;

public class Player {

	private Collection<Bet> bets;

	public Player(Collection<Bet> bets) {
		this.bets = bets;
	}

	public void placeBets(RouletteTable rouletteTable) {
		rouletteTable.placeBets(bets);
	}

}
