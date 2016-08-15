package com.robintegg.roulette.options;

import com.robintegg.roulette.TableLayout;

/**
 * Provides the types of bet available to play
 * 
 * @author robin
 *
 */
public interface BettingOptionsService {

	BettingOptions getBettingOptions(TableLayout layout);

	BettingOption getBettingOption(String name);

}
