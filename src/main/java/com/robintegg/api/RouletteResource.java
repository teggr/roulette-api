package com.robintegg.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.Collection;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.TableLayout;

public class RouletteResource extends ResourceSupport {

	public RouletteResource(Collection<TableLayout> tables) {
		for (TableLayout tableLayout : tables) {
			this.add(linkTo(RouletteController.class, tableLayout.getName()).withRel(tableLayout.getName()));
		}
	}

}
