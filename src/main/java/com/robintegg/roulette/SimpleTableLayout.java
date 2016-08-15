package com.robintegg.roulette;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SimpleTableLayout implements TableLayout {

	private List<Pocket> pockets;
	private String name;

	public SimpleTableLayout(String name, String layout) {
		this.name = name;
		this.pockets = Arrays.asList(layout.split("-")).stream().map(s -> new Pocket(s)).collect(Collectors.toList());
	}

	@Override
	public List<Pocket> getPockets() {
		return pockets;
	}

	@Override
	public String getName() {
		return name;
	}

}
