Feature: Search a product on the online store website ae.com

  Scenario Outline: Add item in the bag
    Given guest user on the home page
    When user accept cookies
    Then user find "<item>"

    Examples:
      | item          |
      | 0195_2518_001 |