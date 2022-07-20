#Author: ajichandran.email@your.domain.com
@Electronics
Feature: Tv
  I want to use this template for my feature file

  Scenario: Tv
    Given user launches flipkart application
    And user login into flipkart
    When user search tv
    And user choose the tv and doing payments
    Then user receive order confirmation message

  Scenario: Tv one dim list
    Given user launches flipkart application
    And user login into flipkart
    When user search tv by using one dim list
      | SAMSUNG | SONY | LG |
    And user choose the tv and doing payments
    Then user receive order confirmation message

  Scenario: Tv one dim map
    Given user launches flipkart application
    And user login into flipkart
    When user search tv by using one dim map
      | Tv1 | SAMSUNG |
      | Tv2 | SONY    |
      | Tv3 | LG      |
    And user choose the tv and doing payments
    Then user receive order confirmation message

  Scenario Outline: All Tvs
    Given user launches flipkart application
    And user login into flipkart
    When user search tv "<Tv>"
    And user choose tv and doing payments
    Then user receive order confirmation message

    Examples: 
      | Tvs     |
      | SAMSUNG |
      | SONY    |
      | LG      |
