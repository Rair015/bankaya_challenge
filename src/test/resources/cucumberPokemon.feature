Feature: test all methods
  Scenario: given the consumer wants to get the name of a pokemon using its id
    When consumer sends a xml name request with pokemon id 132
    Then consumer receives pokemon name 'ditto'

  Scenario: given the consumer wants to get the id of a pokemon using its name
    When consumer sends a xml id request with pokemon name 'pikachu'
    Then consumer receives pokemon id 25

  Scenario: given the consumer wants to know the location area encounters of a pokemon using its name
    When consumer sends a xml locations request with pokemon name 'pikachu'
    Then consumer receives a list of locations for said pokemon

  Scenario: given the consumer wants to know what items the pokemon is holding using its name
    When consumer sends a xml held items request with pokemon name 'ditto'
    Then consumer receives a list of held items for said pokemon

  Scenario: given the consumer wants to know what is the base experience of a pokemon using its name
    When consumer sends a xml base experience request with pokemon name 'mew'
    Then consumer receives the amount of base experience for said pokemon

  Scenario: given the consumer wants to know abilities a pokemon has using its name
    When consumer sends a xml abilities request with pokemon name 'mew'
    Then consumer receives the list of abilities for said pokemon