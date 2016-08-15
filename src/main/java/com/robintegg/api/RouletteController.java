package com.robintegg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robintegg.roulette.RouletteComponent;

@RestController
@RequestMapping("/api/roulette")
public class RouletteController {

	private RouletteComponent roulette;

	@Autowired
	public RouletteController(RouletteComponent roulette) {
		this.roulette = roulette;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Resource<TablesResource> getTables() {
		return new Resource<>(new TablesResource(roulette.getAvailableTables()));
	}

}
