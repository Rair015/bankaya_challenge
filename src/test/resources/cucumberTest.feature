Feature: Get Pokemon name by Id
  Scenario: given the ws has a pokemon data
    When we ask the name of a pokemon with id 132
    Then ws should return pokemon name 'ditto'