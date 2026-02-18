@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given User Lands on Ecommerce Page

  @tag2
  Scenario Outline: Title of your scenario outline
    Given User logged in with the creds <username> and <password>
    When User add the product <productname> to cart
    Then User checks if product <productname> is added in cart
    When User checksout with product <productname>
    	And User select <country> to ship
    	And User place the order

    Examples: 
      | username	  | password  | productname | country |
      | ray@ben.com | RAYben123 | ZARA COAT 3 | India   |
