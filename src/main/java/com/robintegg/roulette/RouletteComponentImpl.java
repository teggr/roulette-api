package com.robintegg.roulette;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouletteComponentImpl implements RouletteComponent {

	private TableLayoutService tableLayoutService;
	private BetsService betsService;

	@Autowired
	public RouletteComponentImpl(TableLayoutService tableLayoutService, BetsService betsService) {
		this.tableLayoutService = tableLayoutService;
		this.betsService = betsService;
	}

	@Override
	public Collection<TableLayout> getAvailableTables() {
		return tableLayoutService.getLayouts();
	}

	@Override
	public BettingOptions getBettingOptions(String tableLayoutName) {
		TableLayout layout = tableLayoutService.getLayout(tableLayoutName);
		return betsService.getBettingOptions(layout);
	}

}
