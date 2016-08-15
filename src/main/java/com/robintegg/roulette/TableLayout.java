package com.robintegg.roulette;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TableLayout {

	EUROPEAN_SINGLE_ZERO("European",
			"0-32-15-19-4-21-2-25-17-34-6-27-13-36-11-30-8-23-10-5-24-16-33-1-20-14-31-9-22-18-29-7-28-12-35-3-26"), AMERICAN_DOUBLE_ZERO(
					"American",
					"0-28-9-26-30-11-7-20-32-17-5-22-34-15-3-24-36-13-1-00-27-10-25-29-12-8-19-31-18-6-21-33-16-4-23-35-14-2");

	private List<Pocket> pockets;
	private String type;

	private TableLayout(String type, String layout) {
		this.type = type;
		this.pockets = Arrays.asList(layout.split("-")).stream().map(s -> new Pocket(s)).collect(Collectors.toList());
	}

	public List<Pocket> getPockets() {
		return pockets;
	}

	public String getType() {
		return type;
	}

}
