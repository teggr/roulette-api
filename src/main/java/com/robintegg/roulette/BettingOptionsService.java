package com.robintegg.roulette;

/**
 * Provides the types of bet available to play
 * 
 * @author robin
 *
 */
interface BettingOptionsService {

	BettingOptions getBettingOptions(TableLayout layout);

	BettingOption getBettingOption(String name);

}
