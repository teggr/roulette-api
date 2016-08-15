package com.robintegg.roulette;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public class RouletteComponentImpl implements RouletteComponent {

	@Override
	public Collection<TableLayout> getAvailableTables() {
		return Arrays.asList(TableLayout.values());
	}

}
