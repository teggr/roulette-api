package com.robintegg.roulette.options;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.robintegg.roulette.TableLayout;

@Service
class BettingOptionsServiceImpl implements BettingOptionsService {

	private Map<String, TogglableOption> optionsByName = new HashMap<String, TogglableOption>();

	public BettingOptionsServiceImpl() {
		register(new StraightOrSingleBet());
		register(new SplitBet());
		register(new LowBet());
		register(new HighBet());
		register(new RedBet());
		register(new BlackBet());
	}

	private void register(BettingOption option) {
		optionsByName.put(option.getName(), new TogglableOption(option));
	}

	@Override
	public BettingOptions getBettingOptions(TableLayout layout) {
		return new BettingOptions(optionsByName.values().stream().filter(t -> t.isEnabled())
				.map(t -> t.getBettingOption()).collect(Collectors.toList()));
	}

	@Override
	public BettingOption getBettingOption(String name) {
		return optionsByName.get(name).getBettingOption();
	}

	@Override
	public Collection<String> getBettingOptionNames() {
		return optionsByName.keySet();
	}

	@Override
	public void toggleOption(String name) {
		optionsByName.get(name).toggle();
	}

	private static class TogglableOption {
		private BettingOption bettingOption;
		private boolean enabled;

		public TogglableOption(BettingOption bettingOption) {
			this.bettingOption = bettingOption;
			this.enabled = true;
		}

		public void toggle() {
			this.enabled = !this.enabled;
		}

		public BettingOption getBettingOption() {
			return bettingOption;
		}

		public boolean isEnabled() {
			return enabled;
		}

	}

}
