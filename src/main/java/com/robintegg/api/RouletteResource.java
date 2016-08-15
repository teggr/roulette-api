package com.robintegg.api;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.Roulette;

public class RouletteResource extends ResourceSupport {

	private Roulette roulette;

	public RouletteResource(Roulette roulette) {
		this.roulette = roulette;
	}

	public Roulette getRoulette() {
		return roulette;
	}

}
