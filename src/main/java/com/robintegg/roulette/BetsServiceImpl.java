package com.robintegg.roulette;

import org.springframework.stereotype.Service;

@Service
class BetsServiceImpl implements BetsService {

	@Override
	public BettingOptions getBettingOptions(TableLayout layout) {
		BettingOptions options = new BettingOptions();
		options.add(new StraightOrSingleBet());
		options.add(new SplitBet());

		options.add(new LowBet());
		options.add(new HighBet());
		options.add(new RedBet());
		options.add(new BlackBet());

		return options;
	}

}
