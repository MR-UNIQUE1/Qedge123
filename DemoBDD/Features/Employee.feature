@tag
Feature: Employee Registration Test
  I want to check Employee Registration Test

  @tag1
  Scenario: Check New Emplyoee Registration
    Given i open browser with url "http://orangehrm.qedgetech.com/"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login button
    Then i should see admin module
    When i goto add employee page
    And i enter firstname as "RAM"
    And i enter lastname as "RAM"
    And i click save
    Then i should see registred employee in employee list
    When i click logout
    Then i should see login page
    And i close the browser

 