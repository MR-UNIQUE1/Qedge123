@tag
Feature: Admin Login
  I want to use this template to check Admin Login

  @tag1
  Scenario: Check Admin Login With Valid Inputs
    Given i open browser with url "http://orangehrm.qedgetech.com/"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login button
    Then i should see admin module
    When i click logout
    Then i should see login page
    And i close the browser

  @tag2
  Scenario Outline: Check Admin Login with invalid inputs
    Given i open browser with url "http://orangehrm.qedgetech.com/"
    Then i should see login page
    When i enter username as "<username>"
    And i enter password as "<password>"
    And i click login button
    Then i should see error message
    When i close the browser

    Examples: 
      | username | password |
      | Admin    | xyz      |
      | xyz      | Qedge123 |
      | abc      | xyz      |
