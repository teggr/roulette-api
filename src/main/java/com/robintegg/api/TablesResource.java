package com.robintegg.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.hateoas.ResourceSupport;

import com.robintegg.roulette.TableLayout;

public class TablesResource extends ResourceSupport {

	private Collection<TableResource> collect;

	public TablesResource(Collection<TableLayout> tables) {

		collect = tables.stream().map(t -> new TableResource(t)).collect(Collectors.toList());

	}

	public Collection<TableResource> getCollect() {
		return collect;
	}
}
