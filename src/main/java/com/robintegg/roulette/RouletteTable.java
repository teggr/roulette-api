package com.robintegg.roulette;

import java.util.ArrayList;
import java.util.Collection;

public class RouletteTable {

	private Wheel wheel;
	private BetValidator betValidator;
	private TableLayout layout;
	private Collection<Bet> bets;

	public RouletteTable(TableLayout layout, BetValidator betValidator) {
		this.layout = layout;
		this.betValidator = betValidator;
		this.wheel = new Wheel(layout.getPockets());
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void placeBets(Collection<Bet> bets) {
		betValidator.validateBets(bets, layout);
		this.bets = bets;
	}

	public Collection<Bet> clearBets() {
		Collection<Bet> list = new ArrayList<>(bets);
		bets.clear();
		return list;
	}

}
