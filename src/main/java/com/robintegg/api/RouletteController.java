package com.robintegg.api;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.robintegg.roulette.BettingResult;
import com.robintegg.roulette.InvalidBetsException;
import com.robintegg.roulette.PlayerBets;
import com.robintegg.roulette.RouletteComponent;

@RestController
@RequestMapping("/api/roulette")
public class RouletteController {

	private static final Logger logger = LoggerFactory.getLogger(RouletteController.class);

	private RouletteComponent roulette;

	private RouletteMetricsCollector metricsCollector;

	@Autowired
	public RouletteController(RouletteComponent roulette, RouletteMetricsCollector metricsCollector) {
		this.roulette = roulette;
		this.metricsCollector = metricsCollector;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Resource<RouletteResource> getRoulette() {

		metricsCollector.newRequest();

		return new Resource<>(new RouletteResource(roulette.getAvailableTables()));
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Resource<TableResource> getTable(@PathVariable("name") String tableLayoutName) {

		metricsCollector.newRequest();

		return new Resource<>(new TableResource(tableLayoutName, roulette.getBettingOptions(tableLayoutName)));
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.POST)
	public Resource<BettingResultsResource> bet(@PathVariable("name") String tableLayoutName,
			@RequestBody PlayerBets playerBets) throws InvalidBetsException {

		logger.info("Placing bets {}", playerBets);

		metricsCollector.newRequest();

		BettingResult result = roulette.play(tableLayoutName, playerBets);

		return new Resource<>(new BettingResultsResource(result));
	}

	@RestControllerAdvice
	public static class RouletteControllerAdvice {

		@ExceptionHandler(InvalidBetsException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		VndErrors invalidBetsException(InvalidBetsException e) {
			return new VndErrors(
					e.getBets().stream().map(i -> new VndErrors.VndError(i.getBet().getName(), i.getReason()))
							.collect(Collectors.toList()));
		}

	}

}
