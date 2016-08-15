package com.robintegg.roulette;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
class BettingOptionsServiceImpl implements BettingOptionsService {

	private Map<String, BettingOption> optionsByName = new HashMap<String, BettingOption>();

	public BettingOptionsServiceImpl() {
		register(new StraightOrSingleBet());
		register(new SplitBet());
		register(new LowBet());
		register(new HighBet());
		register(new RedBet());
		register(new BlackBet());
	}

	private void register(BettingOption option) {
		optionsByName.put(option.getName(), option);
	}

	@Override
	public BettingOptions getBettingOptions(TableLayout layout) {
		return new BettingOptions(optionsByName.values());
	}

	@Override
	public BettingOption getBettingOption(String name) {
		return optionsByName.get(name);
	}

}
