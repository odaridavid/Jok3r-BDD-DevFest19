Feature: Get A Joke
  Sends A query to a Rest endpoint and retrieves a joke displayed to the user
  Scenario: User Wants to get jokes
    Given A user is at the Jokes Screen
    When I click on get a joke button
    Then I should not see default text but a joke