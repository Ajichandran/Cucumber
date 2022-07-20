#Author: ajichandran.email@your.domain.com
@Mobile @Electronics
Feature: Mobile Purchase
  I want to use this template for my feature file
  
  Background:
      Given user launches flipkart application
          And user login into flipkart
      
  

  Scenario: Mobile
   @smoke
    When user search mobile
    And user choose the mobile and doing payments
    Then user receive order confirmation message

  Scenario: Mobile one dim list
  @smoke @sanity @regretion
    When user search mobile by using one dim list
      | Nokia | Vivo | One Plus |
    And user choose the mobile and doing payments
    Then user receive order confirmation message

  Scenario: Tv one dim map
    When user search mobile by using one dim map
      | Phone1 | Vivo     |
      | Phone2 | Nokia    |
      | Phone3 | One Plus |
    And user choose the mobile and doing payments
    Then user receive order confirmation message

  Scenario Outline: All Mobiles
    When user search mobile "<Phones>"
    And user choose mobile and doing payments
    Then user receive order confirmation message

    Examples: 
      | Phones   |
      | Vivo     |
      | Nokia    |
      | One Plus |
