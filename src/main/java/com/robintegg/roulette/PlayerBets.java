package com.robintegg.roulette;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PlayerBets {

	@JsonDeserialize(contentAs = SimpleBet.class)
	private Collection<Bet> bets = new ArrayList<>();

	public Collection<Bet> getBets() {
		return bets;
	}

	@Override
	public String toString() {
		return "PlayerBets [bets=" + bets + "]";
	}

}
