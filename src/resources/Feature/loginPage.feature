Feature: Login Page Functionality
  Scenario: Validate Login
    Given Launch Url
    When User Enter UserName "Admin" and Password "admin123" to login
    Then Verify Page Title "Dashboard"

    Scenario: Forget password link displayed
      Given Launch Url
      Then Forget Password link should be displayed

