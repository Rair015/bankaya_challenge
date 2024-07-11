Feature: Get Pokemon name by Id
  Scenario: given the ws has a pokemon data
    When consumer sends and xml payload with pokemon id 132
    Then consumer receives with pokemon name 'ditto'