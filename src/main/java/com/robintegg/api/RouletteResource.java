package com.robintegg.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Collection;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.TableLayout;

public class RouletteResource extends ResourceSupport {

	public RouletteResource(Collection<TableLayout> tables) {
		for (TableLayout tableLayout : tables) {
			this.add(linkTo(methodOn(RouletteController.class, tableLayout.getName()).getTable(tableLayout.getName()))
					.withRel(tableLayout.getName()));
		}
		this.add(linkTo(RouletteController.class).withSelfRel());
	}

}
