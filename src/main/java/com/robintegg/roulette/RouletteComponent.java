package com.robintegg.roulette;

import java.util.Collection;

public interface RouletteComponent {

	Collection<TableLayout> getAvailableTables();

	BettingOptions getBettingOptions(String tableLayoutName);

}
