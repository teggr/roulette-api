package com.robintegg.roulette;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.robintegg.roulette.options.BettingOption;
import com.robintegg.roulette.options.BettingOptionsService;

public class Croupier implements BetValidator {

	private String name;
	private BettingOptionsService bettingOptionsService;

	public Croupier(String name, BettingOptionsService bettingOptionsService) {
		this.name = name;
		this.bettingOptionsService = bettingOptionsService;
	}

	public String getName() {
		return name;
	}

	public Marker spinWheel(RouletteTable rouletteTable) {
		return new Marker(rouletteTable.getWheel().spin());
	}

	public Winnings makePayouts(Marker marker, RouletteTable rouletteTable) {

		return new Winnings(rouletteTable.clearBets().stream()
				.map(b -> new Winning(marker, b, bettingOptionsService.getBettingOption(b.getName())))
				.collect(Collectors.toList()));

	}

	@Override
	public void validateBets(Collection<Bet> bets, TableLayout layout) throws InvalidBetsException {

		Collection<InvalidBet> invalidBets = new ArrayList<>();
		for (Bet bet : bets) {
			BettingOption option = bettingOptionsService.getBettingOption(bet.getName());
			if (!option.isValid(bet, layout)) {
				invalidBets.add(new InvalidBet("not valid", bet));
			}
		}
		if (!invalidBets.isEmpty()) {
			throw new InvalidBetsException(invalidBets);
		}

	}

}
