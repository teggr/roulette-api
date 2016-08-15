package com.robintegg.roulette;

import java.util.Collection;

import com.robintegg.roulette.options.BettingOptions;

public interface RouletteComponent {

	Collection<TableLayout> getAvailableTables();

	BettingOptions getBettingOptions(String tableLayoutName);

	BettingResult play(String tableLayoutName, PlayerBets playerBets);

}
