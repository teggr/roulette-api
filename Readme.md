# Roulette API Demo

## Technical Choices


# Running the application

Spring boot application can be run through maven

## Requirements

* Java 8

## Github

Clone a copy of this repository

## Using Maven

From the project root directory

	mvn spring-boot:run

or if you don't have maven installed use the packaged maven command (windows ./mvnw.cmd, linux ./mvnw)

	mvnw.cmd spring-boot:run

# API Documentation

All requests start at the root

	http://localhost:8080/api/roulette

This will return a 'RouletteResource' with links the available roulette tables

	{
	  "_links": {
	    "European": {
	      "href": "http://localhost:8080/api/roulette/European"
	    },
	    "American": {
	      "href": "http://localhost:8080/api/roulette/American"
	    },
	    "self": {
	      "href": "http://localhost:8080/api/roulette"
	    }
	  }
	}

Use the links to get a 'TableResource'  upon which you can place bets

	http://localhost:8080/api/roulette/European
	
This 'TableResource' lists all the available bets that you can make and where to post the bets

	{
	  "bettingOptions": {
	    "availableBets": [
	      {
	        "name": "High",
	        "description": "19 to 36 (High or Passe), A bet that the number will be in the chosen range.",
	        "type": "OUTSIDE",
	        "payout": {
	          "payoutAsString": "1 to 1",
	          "payout": 1
	        }
	      },
	      {
	        "name": "Red",
	        "description": "Rouge, A bet that the number will be the chosen color.",
	        "type": "OUTSIDE",
	        "payout": {
	          "payoutAsString": "1 to 1",
	          "payout": 1
	        }
	      }]
	  },
	  "_links": {
	    "self": {
	      "href": "http://localhost:8080/api/roulette/European"
	    },
	    "placebets": {
	      "href": "http://localhost:8080/api/roulette/European"
	    }
	  }
	     
The bets will need to be psoted back to the "placebets" link

	http://localhost:8080/api/roulette/European
	
Post a list of bets using the available bet names. Add stakes and numbers where applicable

	{
	    "bets" : [
	        {
	            "name" : "Red",
	            "stake" : 5.0
	        },
	        {
	            "name" : "High",
	            "stake" : 10.0
	        },
	        {
	            "name" : "Straight/Single",
	            "stake" : 15.0,
	            "numbers" : [ 15 ]
	        }
	    ]
	}	
	
Once the bet has been placed, the result will be returned and contain all the information about the bet placed, the result of the best and details any winings.

	{
	  "result": {
	    "marker": {
	      "pocket": {
	        "number": "26",
	        "colour": "Black",
	        "odd": false,
	        "zero": false,
	        "doubleZero": false,
	        "azero": false,
	        "even": true
	      }
	    },
	    "winnings": {
	      "bets": [
	        {
	          "calculatedWin": 0,
	          "bet": {
	            "name": "Red",
	            "stake": 5,
	            "numbers": null
	          }
	        },
	        {
	          "calculatedWin": 20,
	          "bet": {
	            "name": "High",
	            "stake": 10,
	            "numbers": null
	          }
	        },
	        {
	          "calculatedWin": 0,
	          "bet": {
	            "name": "Straight/Single",
	            "stake": 15,
	            "numbers": [
	              15
	            ]
	          }
	        }
	      ]
	    },
	    "croupier": {
	      "name": "Pierre"
	    }
	  },
	  "_links": {
	    "self": {
	      "href": "http://localhost:8080/api/roulette"
	    }
	  }
	}
	
# Service Management

Betting options can be managed at runtime through the JMX/Jolokia interface

To see a list of available betting options

	http://localhost:8080/jolokia/exec/com.robintegg.manage:name=rouletteManager,type=RouletteManager/getOptions

The "value" object contains the list
	
	{
	  "request": {
	    "mbean": "com.robintegg.manage:name=rouletteManager,type=RouletteManager",
	    "type": "exec",
	    "operation": "getOptions"
	  },
	  "value": [
	    "High",
	    "Red",
	    "Straight/Single",
	    "Low",
	    "Black",
	    "Split"
	  ],
	  "timestamp": 1471303110,
	  "status": 200
	}

To toggle the enabled state of the option

	http://localhost:8080/jolokia/exec/com.robintegg.manage:name=rouletteManager,type=RouletteManager/toggleOption/High
	
Reponse is simply confirmation

	{
	  "request": {
	    "mbean": "com.robintegg.manage:name=rouletteManager,type=RouletteManager",
	    "arguments": [
	      "High"
	    ],
	    "type": "exec",
	    "operation": "toggleOption"
	  },
	  "value": null,
	  "timestamp": 1471303360,
	  "status": 200
	}
	
So depending on the toggled state

	http://localhost:8080/api/roulette/European

May or may not return the High betting option

	...
	{
        "name": "High",
        "description": "19 to 36 (High or Passe), A bet that the number will be in the chosen range.",
        "type": "OUTSIDE",
        "payout": {
          "payoutAsString": "1 to 1",
          "payout": 1
        }
      },
     ...

# Metrics for application performance monitoring

Metrics are exposed through the Spring boot metrics endpoint with extra dropwizard metrics goodness

	http://localhost:8080/metrics
	
In addition to the standard metrics we capture the following

	{
	  ...
	  "roulette.api.requests.meanRate": 0.3375205584404997,
	  "roulette.api.requests.fifteenMinuteRate": 1.1768965957837307,
	  "roulette.api.requests.count": 9,
	  ...
	}
	
# Live deployed endpoint

The API has been deployed to Heroku through the Github connector and is available at

	https://roulette-api.herokuapp.com/
	
To use it replace the localhost:8080 endpoints with the link above

There can be a slight delay when loading the api for the first time on heroku due to it being on the free plan and heroku takes a moment to reload the application from cold
