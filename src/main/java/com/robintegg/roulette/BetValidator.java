package com.robintegg.roulette;

import java.util.Collection;

public interface BetValidator {

	void validateBets(Collection<Bet> bets, TableLayout layout) throws InvalidBetsException;

}
