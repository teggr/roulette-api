package com.robintegg.roulette;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robintegg.roulette.options.BettingOptions;
import com.robintegg.roulette.options.BettingOptionsService;

@Component
public class RouletteComponentImpl implements RouletteComponent {

	private TableLayoutService tableLayoutService;
	private BettingOptionsService bettingOptionsService;

	@Autowired
	public RouletteComponentImpl(TableLayoutService tableLayoutService, BettingOptionsService bettingOptionsService) {
		this.tableLayoutService = tableLayoutService;
		this.bettingOptionsService = bettingOptionsService;
	}

	@Override
	public Collection<TableLayout> getAvailableTables() {
		return tableLayoutService.getLayouts();
	}

	@Override
	public BettingOptions getBettingOptions(String tableLayoutName) {
		TableLayout layout = tableLayoutService.getLayout(tableLayoutName);
		return bettingOptionsService.getBettingOptions(layout);
	}

	@Override
	public BettingResult play(String tableLayoutName, PlayerBets playerBets) {

		Player player = new Player(playerBets.getBets());

		Croupier croupier = new Croupier("Pierre", bettingOptionsService);

		TableLayout layout = tableLayoutService.getLayout(tableLayoutName);

		RouletteTable rouletteTable = new RouletteTable(layout, croupier);

		player.placeBets(rouletteTable);

		Marker marker = croupier.spinWheel(rouletteTable);

		Winnings winnings = croupier.makePayouts(marker, rouletteTable);

		return new BettingResult(croupier, marker, winnings);

	}

}
