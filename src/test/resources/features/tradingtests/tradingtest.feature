
Feature: My trading feature 

    Scenario: My trade scenario test
        Given There is a user "Diamond"
        And There is a user "Paper"
        And There is a security "WSB"
        When User "Diamond" puts a buy order for security "WSB" with a price of 101.0 and quantity of 50.0
        When User "Paper" puts a sell order for security "WSB" with a price of 100.0 and quantity of 100.0
        Then A trade occurs with the price of 100.0 and quantity of 50.0

    Scenario: My trade scenario test 2
        Given There is a user "Diamond"
        And There is a user "Paper"
        And There is a security "WSB"
        When User "Paper" puts a buy order for security "WSB" with a price of 90.5 and quantity of 20.0
        When User "Diamond" puts a sell order for security "WSB" with a price of 80.2 and quantity of 5.7
        Then A trade occurs with the price of 80.2 and quantity of 5.7