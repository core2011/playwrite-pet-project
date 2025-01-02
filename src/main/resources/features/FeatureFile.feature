Feature: Search a product on the online store website ae.com

  Scenario Outline: Add item in the bag
    Given guest user on the home page
    When user accept cookies
    Then user find "<item>"
    Then verify product name "<nameItem>"
    Then click on the item and verify user on PDP page
    Then choose first not OOS size
    And click on Add to bag button
    Then verify user on the cart page
    When scroll to the item on cart page


    Examples:
      | item          | nameItem                       |
      | 0195_2518_001 | AE 24/7 Textured Fleece Hoodie |
#      | 0427_7782_001 | AE Quilted Heart Bag           |