@wip
Feature: Question feature

  Background:
    Given user open the website

  Scenario: User should be see how to add a question answer
    When user click How to add a question? tab
    Then user should be able to see "Just use the form below!" message


  Scenario: User should be able to create question
    When user type question in the Question area
    And user type answer in the answer area
    And user click Create question button
    Then user should be see own question in the question section
    Then user should see an increasing number of questions


  Scenario: User should be able to sort question
    When user type question in the Question area
    And user type answer in the answer area
    And user click Create question button
    When user click sort question button
    Then user should be see sorted question


  Scenario: User should be able to delete questions
    When user click Remove Questions button
    Then user should be see "No questions yet :-(" message


  Scenario: User should be able to see  error message
    When user click Create question button without filling any fields
    Then user should be see "Please fill in this field." messages

