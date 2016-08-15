# Product Selection Page Demo

## Technical Choices


## Running the application

### Requirements

* Java 8

### Github

Clone a copy of this repository

### Using Maven

From the project root directory

	mvn spring-boot:run

or if you don't have maven installed use the packaged maven command (windows ./mvnw.cmd, linux ./mvnw)

	mvnw.cmd spring-boot:run

## API Documentation

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