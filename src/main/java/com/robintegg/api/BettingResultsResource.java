package com.robintegg.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.BettingResult;

public class BettingResultsResource extends ResourceSupport {

	private BettingResult result;

	public BettingResultsResource(BettingResult result) {
		this.result = result;
		this.add(linkTo(RouletteController.class).withSelfRel());
	}

	public BettingResult getResult() {
		return result;
	}

}
