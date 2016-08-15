package com.robintegg.api;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.BettingOptions;

public class TableResource extends ResourceSupport {

	private BettingOptions bettingOptions;

	public TableResource(BettingOptions bettingOptions) {
		this.bettingOptions = bettingOptions;
	}

	public BettingOptions getBets() {
		return bettingOptions;
	}

}
