package com.robintegg.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codahale.metrics.MetricRegistry;
import com.robintegg.api.RouletteMetricsCollector;

@Component
public class RouletteMetrics implements RouletteMetricsCollector {

	private MetricRegistry registry;

	@Autowired
	public RouletteMetrics(MetricRegistry registry) {
		this.registry = registry;
	}

	@Override
	public void newRequest() {

		this.registry.meter("roulette.api.requests").mark();

	}

}
