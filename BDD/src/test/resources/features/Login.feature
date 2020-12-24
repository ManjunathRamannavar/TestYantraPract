Feature: Login feature

  Background: 
    Given I want to launch the browser
    And I enter the url "http://localhost:8888/"

  Scenario: I want to login to vtiger application using valid credentials
    When Login page is displayed enter the username and password and click on login
    Then Home page should be displayed