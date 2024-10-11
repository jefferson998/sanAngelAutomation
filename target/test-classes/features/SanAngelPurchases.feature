@test-san-angel
Feature: San angel purchases

  Scenario Outline: Add 2 products to cart
    Given user enter to page san angel "https://sanangel.com.co/"
    When add product "<nameProduct>" with quantity "<quantity>" in cart
    And add product "<nameProduct2>" with quantity "<quantity2>" in cart
    Then the cart should contain the following products:
      | nameProduct    | quantity    |
      | <nameProduct>  | <quantity>  |
      | <nameProduct2> | <quantity2> |

    Examples:
      | nameProduct | quantity | nameProduct2 | quantity2 |
      | Presente    | 1        | Destellos    | 1         |


  Scenario Outline: Add 1 product with 2 quantity to cart
    Given user enter to page san angel "https://sanangel.com.co/"
    When add product "<nameProduct>" with quantity "<quantity>" in cart
    Then the cart should contain the following products:
      | nameProduct   | quantity   |
      | <nameProduct> | <quantity> |


    Examples:
      | nameProduct | quantity |
      | Presente    | 1        |

  Scenario Outline: Add 2 product with 5 quantity to cart
    Given user enter to page san angel "https://sanangel.com.co/"
    When add product "<nameProduct>" with quantity "<quantity>" in cart
    And add product "<nameProduct2>" with quantity "<quantity2>" in cart
    Then the cart should contain the following products:
      | nameProduct    | quantity    |
      | <nameProduct>  | <quantity>  |
      | <nameProduct2> | <quantity2> |

    Examples:
      | nameProduct | quantity | nameProduct2 | quantity2 |
      | Presente    | 5       | Destellos    | 5         |

