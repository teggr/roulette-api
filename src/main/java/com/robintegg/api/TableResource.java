package com.robintegg.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.BettingOptions;

public class TableResource extends ResourceSupport {

	private BettingOptions bettingOptions;

	public TableResource(String tableLayoutName, BettingOptions bettingOptions) {
		this.bettingOptions = bettingOptions;
		this.add(linkTo(methodOn(RouletteController.class, tableLayoutName).getTable(tableLayoutName)).withSelfRel());
		this.add(linkTo(methodOn(RouletteController.class, tableLayoutName).bet(tableLayoutName, null))
				.withRel("placebets"));
	}

	public BettingOptions getBettingOptions() {
		return bettingOptions;
	}

}
