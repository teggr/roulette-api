package com.robintegg.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.robintegg.roulette.options.BettingOptionsService;

@ManagedResource
@Component
public class RouletteManager {

	private BettingOptionsService bettingOptionsService;

	@Autowired
	public RouletteManager(BettingOptionsService bettingOptionsService) {
		this.bettingOptionsService = bettingOptionsService;
	}

	@ManagedOperation(description = "Get the betting option names")
	public String[] getOptions() {
		return bettingOptionsService.getBettingOptionNames().toArray(new String[] {});
	}

	@ManagedOperation(description = "Toggle enabled state of options")
	public void toggleOption(String name) {
		bettingOptionsService.toggleOption(name);
	}

}
